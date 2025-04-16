package com.scheduling.schedule.usecase;

import com.scheduling.schedule.dto.SchedulingDTO;
import com.scheduling.schedule.service.SchedulingService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class RetriveAllSchedulingsUseCase {

    private final SchedulingService schedulingService;

    public RetriveAllSchedulingsUseCase(SchedulingService schedulingService) {
        this.schedulingService = schedulingService;
    }

    public Page<SchedulingDTO> execute(Pageable pageable, SchedulingDTO roomDTOFilter) {
        return schedulingService.retrieveAll(pageable, roomDTOFilter);
    }
}
