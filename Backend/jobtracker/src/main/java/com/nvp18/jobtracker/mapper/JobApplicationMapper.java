package com.nvp18.jobtracker.mapper;

import com.nvp18.jobtracker.constants.ApplicationStatus;
import com.nvp18.jobtracker.constants.JobType;
import com.nvp18.jobtracker.dao.JobApplicationDAO;
import com.nvp18.jobtracker.dto.JobApplicationDTO;

public class JobApplicationMapper {

    public static JobApplicationDAO mapJobApplicationDao(JobApplicationDTO jobApplicationDTO) {
        return JobApplicationDAO.builder()
                .jobType(JobType.valueOf(jobApplicationDTO.getJobType()))
                .jobLink(jobApplicationDTO.getJobLink())
                .jobTitle(jobApplicationDTO.getJobTitle())
                .appliedDate(jobApplicationDTO.getAppliedDate())
                .companyName(jobApplicationDTO.getCompanyName())
                .location(jobApplicationDTO.getLocation())
                .source(jobApplicationDTO.getSource())
                .status(ApplicationStatus.valueOf(jobApplicationDTO.getStatus()))
                .build();
    }

    public static JobApplicationDTO mapJobApplicationDTO(JobApplicationDAO jobApplicationDAO) {
        return JobApplicationDTO.builder()
                .jobType(jobApplicationDAO.getJobType().toString())
                .jobLink(jobApplicationDAO.getJobLink())
                .jobTitle(jobApplicationDAO.getJobTitle())
                .appliedDate(jobApplicationDAO.getAppliedDate())
                .companyName(jobApplicationDAO.getCompanyName())
                .location(jobApplicationDAO.getLocation())
                .source(jobApplicationDAO.getSource())
                .status(jobApplicationDAO.getStatus().toString())
                .jobId(jobApplicationDAO.getJobId())
                .build();
    }
}
