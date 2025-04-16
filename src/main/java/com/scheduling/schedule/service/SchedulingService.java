package com.scheduling.schedule.service;

import com.scheduling.model.Scheduling;
import com.scheduling.repository.CustomSpecifications;
import com.scheduling.schedule.constants.SchedulingConstants;
import com.scheduling.schedule.dto.SchedulingDTO;
import com.scheduling.schedule.repository.SchedulingRepository;
import com.scheduling.schedule.repository.SchedulingSpecification;
import com.scheduling.schedule.translator.SchedulingTranslator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SchedulingService {


    private final SchedulingRepository schedulingRepository;
    private final SchedulingTranslator schedulingTranslator;

    public SchedulingService(SchedulingRepository schedulingRepository, SchedulingTranslator schedulingTranslator) {
        this.schedulingRepository = schedulingRepository;
        this.schedulingTranslator = schedulingTranslator;
    }

    public SchedulingDTO create(SchedulingDTO schedulingDTO) {
        Scheduling savedScheduling = schedulingRepository.save(schedulingTranslator.toEntity(schedulingDTO));
        return schedulingTranslator.toDTO(savedScheduling);
    }

    public Optional<SchedulingDTO> retrieve(Long id) {
        Optional<Scheduling> entity = schedulingRepository.findById(id);
        return entity.map(schedulingTranslator::toDTO);
    }

    public Page<SchedulingDTO> retrieveAll(Pageable pageable, SchedulingDTO schedulingDTOFilter) {
        List<Specification<Scheduling>> specificationList = new ArrayList<>();

        if(schedulingDTOFilter.getRoomId() != null)
            specificationList.add(SchedulingSpecification.equalRoomId(schedulingDTOFilter.getRoomId()));


        if(schedulingDTOFilter.getDate() != null)
            specificationList.add(CustomSpecifications.equal(SchedulingConstants.DATE, schedulingDTOFilter.getDate()));

        Specification<Scheduling> specification = Specification.allOf(specificationList);
        Page<Scheduling> allRooms = schedulingRepository.findAll(specification, pageable);
        return allRooms.map(schedulingTranslator::toDTO);
    }
}
