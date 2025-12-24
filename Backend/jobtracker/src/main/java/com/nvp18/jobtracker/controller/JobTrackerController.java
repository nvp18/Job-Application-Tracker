package com.nvp18.jobtracker.controller;

import com.nvp18.jobtracker.dto.JobApplicationDTO;
import com.nvp18.jobtracker.dto.ApplicationResponseDTO;
import com.nvp18.jobtracker.dto.UpdateStatusDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class JobTrackerController {

    @GetMapping("/job-applications")
    public ResponseEntity<ApplicationResponseDTO> getAllJobApplications() {
        List<JobApplicationDTO> jobApplicationDTOList = new ArrayList<>();
        jobApplicationDTOList.add(new JobApplicationDTO());
        jobApplicationDTOList.add(new JobApplicationDTO());
        ApplicationResponseDTO responseDTO = new ApplicationResponseDTO();
        responseDTO.setData(jobApplicationDTOList);
        responseDTO.setMessage("Fetched All Applications");
        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping("/job-applications")
    public ResponseEntity<ApplicationResponseDTO> addJobApplication(@RequestBody JobApplicationDTO jobApplication) {
        ApplicationResponseDTO applicationResponseDTO = new ApplicationResponseDTO();
        applicationResponseDTO.setData(List.of(jobApplication));
        applicationResponseDTO.setMessage("Added new job application with id: "+jobApplication.getJobId());
        return ResponseEntity.status(HttpStatus.CREATED).body(applicationResponseDTO);
    }

    @PatchMapping("/job-applications/{id}/status")
    public ResponseEntity<ApplicationResponseDTO> updateJobApplicationStatus(@PathVariable String id
            , @RequestBody UpdateStatusDTO updateStatusDTO) {
        ApplicationResponseDTO applicationResponseDTO = new ApplicationResponseDTO();
        applicationResponseDTO.setMessage("Updated job application with id: "+id);
        return ResponseEntity.status(HttpStatus.OK).body(applicationResponseDTO);
    }

    @DeleteMapping("/job-applications/{id}")
    public ResponseEntity<Void> deleteJobApplication(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
