package com.scheduling.room.service;

import com.scheduling.model.Room;
import com.scheduling.repository.CustomSpecifications;
import com.scheduling.room.constants.RoomConstants;
import com.scheduling.room.dto.RoomDTO;
import com.scheduling.room.repository.RoomRepository;
import com.scheduling.room.translator.RoomTranslator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    private final RoomRepository roomRepository;
    private final RoomTranslator roomTranslator;

    public RoomService(RoomRepository roomRepository, RoomTranslator roomTranslator) {
        this.roomRepository = roomRepository;
        this.roomTranslator = roomTranslator;
    }

    public Optional<RoomDTO> retrieve(String name) {
        Optional<Room> entity = roomRepository.findByName(name);
        return entity.map(roomTranslator::toDTO);
    }

    public RoomDTO create(RoomDTO room) {
        Room savedRoom = roomRepository.save(roomTranslator.toEntity(room));
        return roomTranslator.toDTO(savedRoom);
    }

    public Optional<RoomDTO> retrieve(Long id) {
        Optional<Room> entity = roomRepository.findById(id);
        return entity.map(roomTranslator::toDTO);
    }

    public Page<RoomDTO> retrieveAll(Pageable pageable, RoomDTO roomDTOFilter) {
        List<Specification<Room>> specificationList = new ArrayList<>();

        if(roomDTOFilter.getName() != null)
            specificationList.add(CustomSpecifications.equal(RoomConstants.NAME, roomDTOFilter.getName()));

        if(roomDTOFilter.getDescription() != null)
            specificationList.add(CustomSpecifications.like(RoomConstants.DESCRIPTION, roomDTOFilter.getDescription()));

        Specification<Room> specification = Specification.allOf(specificationList);
        Page<Room> allRooms = roomRepository.findAll(specification, pageable);
        return allRooms.map(roomTranslator::toDTO);
    }
}
