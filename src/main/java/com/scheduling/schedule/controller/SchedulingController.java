package com.scheduling.schedule.controller;

import com.scheduling.exception.NotFoundException;
import com.scheduling.room.dto.RoomDTO;
import com.scheduling.room.exception.SchedulingConflictException;
import com.scheduling.room.usecase.CreateRoomUseCase;
import com.scheduling.room.usecase.RetrieveRoomUseCase;
import com.scheduling.room.usecase.RetriveAllRoomsUseCase;
import com.scheduling.schedule.dto.SchedulingDTO;
import com.scheduling.schedule.usecase.CreateSchedulingUseCase;
import com.scheduling.schedule.usecase.RetrieveSchedulingUseCase;
import com.scheduling.schedule.usecase.RetriveAllSchedulingsUseCase;
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
@RequestMapping("/promarket/api/v1/schedulings")
public class SchedulingController {

    private final CreateSchedulingUseCase createSchedulingUseCase;
    private final RetrieveSchedulingUseCase retrieveSchedulingUseCase;
    private final RetriveAllSchedulingsUseCase retriveAllSchedulingsUseCase;

    public SchedulingController(CreateSchedulingUseCase createSchedulingUseCase, RetrieveSchedulingUseCase retrieveSchedulingUseCase, RetriveAllSchedulingsUseCase retriveAllSchedulingsUseCase) {
        this.createSchedulingUseCase = createSchedulingUseCase;
        this.retrieveSchedulingUseCase = retrieveSchedulingUseCase;
        this.retriveAllSchedulingsUseCase = retriveAllSchedulingsUseCase;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EntityModel<SchedulingDTO>> create(@Valid @RequestBody SchedulingDTO scheduling) throws SchedulingConflictException {
        return new ResponseEntity<>(
                EntityModel.of(createSchedulingUseCase.execute(scheduling)),
                HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EntityModel<SchedulingDTO>> retrieve(@PathVariable Long id) throws NotFoundException {
        return new ResponseEntity<>(
                EntityModel.of(retrieveSchedulingUseCase.execute(id)),
                HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PagedModel<EntityModel<SchedulingDTO>>> retrieveAll(
            @PageableDefault(page = 0, size = 50) Pageable pageable,
            SchedulingDTO schedulingDTOFilter,
            PagedResourcesAssembler<SchedulingDTO> assembler) {
        Page<SchedulingDTO> pagedRoom = retriveAllSchedulingsUseCase.execute(pageable, schedulingDTOFilter);
        return ResponseEntity.ok(assembler.toModel(pagedRoom));
    }

}
