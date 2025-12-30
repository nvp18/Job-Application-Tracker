package com.nvp18.jobtracker.service;

import com.nvp18.jobtracker.dto.CompanyDTO;
import com.nvp18.jobtracker.dto.JobBoardDTO;

import java.util.List;

public interface JobBoardService {

    JobBoardDTO addJobBoard(JobBoardDTO jobBoardDTO);

    List<JobBoardDTO> getAllJobBoards();

    void deleteJobBoard(String atsId);

    JobBoardDTO updateJobBoard(JobBoardDTO jobBoardDTO);

    CompanyDTO addCompany(CompanyDTO companyDTO, String atsID);
}
