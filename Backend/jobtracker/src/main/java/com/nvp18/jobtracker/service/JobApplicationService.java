package com.nvp18.jobtracker.service;

import com.nvp18.jobtracker.dto.ApplicationResponseDTO;
import com.nvp18.jobtracker.dto.JobApplicationDTO;

import java.util.List;

public interface JobApplicationService {

    JobApplicationDTO addJobApplication(JobApplicationDTO jobApplicationDTO);
}
