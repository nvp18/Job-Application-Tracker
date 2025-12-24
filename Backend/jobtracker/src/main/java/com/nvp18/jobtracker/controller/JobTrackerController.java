package com.nvp18.jobtracker.controller;

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
        JobApplicationDTO jobApplicationDTO = jobApplicationService.addJobApplication(jobApplication);
        ApplicationResponseDTO applicationResponseDTO = new ApplicationResponseDTO();
        applicationResponseDTO.setData(List.of(jobApplicationDTO));
        applicationResponseDTO.setMessage("Added new job application with id: "+jobApplicationDTO.getJobId());
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
