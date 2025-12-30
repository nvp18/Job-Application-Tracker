package com.nvp18.jobtracker.mapper;

import com.nvp18.jobtracker.constants.ApplicationStatus;
import com.nvp18.jobtracker.constants.JobType;
import com.nvp18.jobtracker.dao.CompanyDao;
import com.nvp18.jobtracker.dao.JobApplicationDAO;
import com.nvp18.jobtracker.dao.JobBoardDao;
import com.nvp18.jobtracker.dto.CompanyDTO;
import com.nvp18.jobtracker.dto.JobApplicationDTO;
import com.nvp18.jobtracker.dto.JobBoardDTO;

public class JobBoardMapper {

    public static JobBoardDao mapJobBoardDao(JobBoardDTO jobBoardDTO) {
        return JobBoardDao.builder()
                .name(jobBoardDTO.getName())
                .requiresAuth(jobBoardDTO.getRequiresAuth()!=null ? jobBoardDTO.getRequiresAuth() : false)
                .hasJobUrl(jobBoardDTO.getHasJobUrl()!=null ? jobBoardDTO.getHasJobUrl() : false)
                .baseUrl(jobBoardDTO.getBaseUrl())
                .jobUrl(jobBoardDTO.getJobUrl())
                .build();
    }

    public static JobBoardDTO mapJobBoardDTO(JobBoardDao jobBoardDao) {
        return JobBoardDTO.builder()
                .atsId(jobBoardDao.getAtsId())
                .name(jobBoardDao.getName())
                .requiresAuth(jobBoardDao.getRequiresAuth())
                .hasJobUrl(jobBoardDao.getHasJobUrl())
                .baseUrl(jobBoardDao.getBaseUrl())
                .jobUrl(jobBoardDao.getJobUrl())
                .build();
    }

    public static CompanyDTO mapCompanyDTO(CompanyDao companyDao) {
        return CompanyDTO.builder()
                .companyId(companyDao.getCompanyId())
                .companyName(companyDao.getCompanyName())
                .companySlug(companyDao.getCompanySlug())
                .build();
    }

    public static CompanyDao mapCompanyDao(CompanyDTO companyDTO) {
        return CompanyDao.builder()
                .companyName(companyDTO.getCompanyName())
                .companySlug(companyDTO.getCompanySlug())
                .build();
    }
}
