package com.nvp18.jobtracker.controller;

import com.nvp18.jobtracker.constants.ApplicationStatus;
import com.nvp18.jobtracker.dto.JobApplicationDTO;
import com.nvp18.jobtracker.dto.ApplicationResponseDTO;
import com.nvp18.jobtracker.dto.UpdateStatusDTO;
import com.nvp18.jobtracker.service.JobApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class JobTrackerController {

    @Autowired
    private JobApplicationService jobApplicationService;

    @GetMapping("/job-applications")
    public ResponseEntity<ApplicationResponseDTO> getAllJobApplications() {
        List<JobApplicationDTO> jobApplicationDTOS = jobApplicationService.getAllJobApplications(1);
        ApplicationResponseDTO responseDTO = new ApplicationResponseDTO();
        responseDTO.setData(jobApplicationDTOS);
        responseDTO.setMessage("Fetched All Applications");
        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping("/job-applications")
    public ResponseEntity<ApplicationResponseDTO> addJobApplication(@RequestBody JobApplicationDTO jobApplication) {
        JobApplicationDTO jobApplicationDTO = jobApplicationService.addJobApplication(jobApplication);
        ApplicationResponseDTO applicationResponseDTO = new ApplicationResponseDTO();
        applicationResponseDTO.setData(List.of(jobApplicationDTO));
        applicationResponseDTO.setMessage("Added new job application with id: "+jobApplicationDTO.getJobId());
        return ResponseEntity.status(HttpStatus.CREATED).body(applicationResponseDTO);
    }

    @PatchMapping("/job-applications/{id}/status")
    public ResponseEntity<ApplicationResponseDTO> updateJobApplicationStatus(@PathVariable Integer id
            , @RequestBody UpdateStatusDTO updateStatusDTO) {
        JobApplicationDTO jobApplicationDTO = jobApplicationService.updateJobApplication(id, updateStatusDTO.getStatus());
        ApplicationResponseDTO responseDTO = ApplicationResponseDTO.builder()
                .data(List.of(jobApplicationDTO))
                .message("Updated Job Status")
                .build();
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/job-applications/{id}")
    public ResponseEntity<Void> deleteJobApplication(@PathVariable Integer id) {
        jobApplicationService.deleteJobApplication(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
