package com.nvp18.jobtracker.service;

import com.nvp18.jobtracker.constants.ApplicationStatus;
import com.nvp18.jobtracker.constants.JobType;
import com.nvp18.jobtracker.dto.ApplicationResponseDTO;
import com.nvp18.jobtracker.dto.JobApplicationDTO;
import com.nvp18.jobtracker.exception.ApplicationNotFoundException;

import java.util.List;

public interface JobApplicationService {

    JobApplicationDTO addJobApplication(JobApplicationDTO jobApplicationDTO);

    JobApplicationDTO updateJobApplication(Integer id, ApplicationStatus status) throws ApplicationNotFoundException;

    void deleteJobApplication(Integer id) throws ApplicationNotFoundException;

    List<JobApplicationDTO> getAllJobApplications(Integer userId);
}
