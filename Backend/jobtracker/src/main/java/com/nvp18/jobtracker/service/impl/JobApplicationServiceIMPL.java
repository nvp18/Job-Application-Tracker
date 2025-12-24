package com.nvp18.jobtracker.service.impl;

import com.nvp18.jobtracker.dao.JobApplicationDAO;
import com.nvp18.jobtracker.dto.JobApplicationDTO;
import com.nvp18.jobtracker.mapper.JobApplicationMapper;
import com.nvp18.jobtracker.repository.JobApplicationRepository;
import com.nvp18.jobtracker.service.JobApplicationService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobApplicationServiceIMPL implements JobApplicationService {

    @Autowired
    private JobApplicationRepository jobApplicationRepository;

    @Transactional
    @Override
    public JobApplicationDTO addJobApplication(JobApplicationDTO jobApplicationDTO) {
        JobApplicationDAO jobApplicationDAO = jobApplicationRepository.save(JobApplicationMapper.mapJobApplicationDao(jobApplicationDTO));
        return JobApplicationMapper.mapJobApplicationDTO(jobApplicationDAO);
    }
}
