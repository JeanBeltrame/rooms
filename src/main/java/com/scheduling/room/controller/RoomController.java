package com.scheduling.room.controller;

import com.scheduling.exception.NotFoundException;
import com.scheduling.room.dto.RoomDTO;
import com.scheduling.room.usecase.CreateRoomUseCase;
import com.scheduling.room.usecase.RetrieveRoomUseCase;
import com.scheduling.room.usecase.RetriveAllRoomsUseCase;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.InstanceAlreadyExistsException;

@RestController
@RequestMapping("/promarket/api/v1/rooms")
public class RoomController {

    private final CreateRoomUseCase createRoomUseCase;
    private final RetrieveRoomUseCase retrieveRoomUseCase;
    private final RetriveAllRoomsUseCase retriveAllRoomsUseCase;

    public RoomController(CreateRoomUseCase createRoomUseCase, RetrieveRoomUseCase retrieveRoomUseCase, RetriveAllRoomsUseCase retriveAllRoomsUseCase) {
        this.createRoomUseCase = createRoomUseCase;
        this.retrieveRoomUseCase = retrieveRoomUseCase;
        this.retriveAllRoomsUseCase = retriveAllRoomsUseCase;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EntityModel<RoomDTO>> create(@Valid @RequestBody RoomDTO room) throws InstanceAlreadyExistsException {
        return new ResponseEntity<>(
                EntityModel.of(createRoomUseCase.execute(room)),
                HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EntityModel<RoomDTO>> retrieve(@PathVariable Long id) throws NotFoundException {
        return new ResponseEntity<>(
                EntityModel.of(retrieveRoomUseCase.execute(id)),
                HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PagedModel<EntityModel<RoomDTO>>> retrieveAll(
            @PageableDefault(page = 0, size = 50) Pageable pageable,
            RoomDTO roomDTOFilter,
            PagedResourcesAssembler<RoomDTO> assembler) {
        Page<RoomDTO> pagedRoom = retriveAllRoomsUseCase.execute(pageable, roomDTOFilter);
        return ResponseEntity.ok(assembler.toModel(pagedRoom));
    }

}
