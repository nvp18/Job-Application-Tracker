package com.nvp18.jobtracker.controller;

import com.nvp18.jobtracker.dto.ApplicationResponseDTO;
import com.nvp18.jobtracker.dto.CompanyDTO;
import com.nvp18.jobtracker.dto.JobBoardDTO;
import com.nvp18.jobtracker.service.JobBoardService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/jobBoard")
public class JobScrapperController {

    @Autowired
    private JobBoardService jobBoardService;

    @PostMapping("/addJobBoard")
    public ResponseEntity<ApplicationResponseDTO> addJobBoard(@RequestBody JobBoardDTO jobBoardDTO) {
        JobBoardDTO response = jobBoardService.addJobBoard(jobBoardDTO);
        ApplicationResponseDTO<JobBoardDTO> applicationResponseDTO = ApplicationResponseDTO.<JobBoardDTO>builder()
                .message("Successfully Added new Job Board")
                .data(List.of(response))
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(applicationResponseDTO);
    }

    @PostMapping("/addCompany/{jobBoardId}")
    public ResponseEntity<ApplicationResponseDTO> addCompany(@PathVariable("jobBoardId") String atsId, @RequestBody CompanyDTO companyDTO) {
        CompanyDTO response = jobBoardService.addCompany(companyDTO, atsId);
        ApplicationResponseDTO<CompanyDTO> applicationResponseDTO = ApplicationResponseDTO.<CompanyDTO>builder()
                .message("Successfully Added new Company")
                .data(List.of(response))
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(applicationResponseDTO);
    }
}
