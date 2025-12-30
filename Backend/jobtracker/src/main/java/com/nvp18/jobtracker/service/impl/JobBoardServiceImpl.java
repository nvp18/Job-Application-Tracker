package com.nvp18.jobtracker.service.impl;

import com.nvp18.jobtracker.dao.CompanyDao;
import com.nvp18.jobtracker.dao.JobBoardDao;
import com.nvp18.jobtracker.dto.CompanyDTO;
import com.nvp18.jobtracker.dto.JobBoardDTO;
import com.nvp18.jobtracker.mapper.JobBoardMapper;
import com.nvp18.jobtracker.repository.CompanyRepository;
import com.nvp18.jobtracker.repository.JobBoardRepository;
import com.nvp18.jobtracker.service.JobBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobBoardServiceImpl implements JobBoardService {

    @Autowired
    private JobBoardRepository jobBoardRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public JobBoardDTO addJobBoard(JobBoardDTO jobBoardDTO) {
        JobBoardDao jobBoardDao = JobBoardMapper.mapJobBoardDao(jobBoardDTO);
        return JobBoardMapper.mapJobBoardDTO(jobBoardRepository.save(jobBoardDao));
    }

    @Override
    public List<JobBoardDTO> getAllJobBoards() {
        return null;
    }

    @Override
    public void deleteJobBoard(String atsId) {

    }

    @Override
    public JobBoardDTO updateJobBoard(JobBoardDTO jobBoardDTO) {
        return null;
    }

    @Override
    public CompanyDTO addCompany(CompanyDTO companyDTO, String atsID) {
        Optional<JobBoardDao> jobBoardDao = jobBoardRepository.findById(atsID);
        if(jobBoardDao.isPresent()) {
            CompanyDao companyDao = JobBoardMapper.mapCompanyDao(companyDTO);
            companyDao.setJobBoardDao(jobBoardDao.get());
            return JobBoardMapper.mapCompanyDTO(companyRepository.save(companyDao));
        } else {
            return new CompanyDTO();
        }
    }
}
