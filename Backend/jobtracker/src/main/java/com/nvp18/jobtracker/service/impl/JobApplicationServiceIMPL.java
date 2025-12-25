package com.nvp18.jobtracker.service.impl;

import com.nvp18.jobtracker.constants.ApplicationStatus;
import com.nvp18.jobtracker.dao.JobApplicationDAO;
import com.nvp18.jobtracker.dao.User;
import com.nvp18.jobtracker.dto.JobApplicationDTO;
import com.nvp18.jobtracker.exception.ApplicationNotFoundException;
import com.nvp18.jobtracker.exception.UserNotFoundException;
import com.nvp18.jobtracker.mapper.JobApplicationMapper;
import com.nvp18.jobtracker.repository.JobApplicationRepository;
import com.nvp18.jobtracker.repository.UserRepository;
import com.nvp18.jobtracker.service.JobApplicationService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobApplicationServiceIMPL implements JobApplicationService {

    @Autowired
    private JobApplicationRepository jobApplicationRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public JobApplicationDTO addJobApplication(JobApplicationDTO jobApplicationDTO) {
        Optional<User> user = userRepository.findById(1);
        JobApplicationDAO jobApplicationDAO = JobApplicationMapper.mapJobApplicationDao(jobApplicationDTO);
        if(user.isPresent()) {
            jobApplicationDAO.setUser(user.get());
            JobApplicationDAO savedDao = jobApplicationRepository.save(jobApplicationDAO);
            return JobApplicationMapper.mapJobApplicationDTO(savedDao);
        } else {
            throw new UserNotFoundException("User Not Found");
        }
    }

    @Override
    public JobApplicationDTO updateJobApplication(Integer id, ApplicationStatus status) throws ApplicationNotFoundException {
        Optional<JobApplicationDAO> jobApplicationDAO = jobApplicationRepository.findById(id);
        if(jobApplicationDAO.isPresent()) {
            JobApplicationDAO updatedDao = jobApplicationDAO.get();
            updatedDao.setStatus(status);
            jobApplicationRepository.save(updatedDao);
            return JobApplicationMapper.mapJobApplicationDTO(updatedDao);
        } else {
            throw new ApplicationNotFoundException("Job Not Found");
        }
    }


    @Override
    public void deleteJobApplication(Integer id) throws ApplicationNotFoundException {
        Optional<JobApplicationDAO> jobApplicationDAO = jobApplicationRepository.findById(id);
        if(jobApplicationDAO.isPresent()) {
            JobApplicationDAO deletedDao = jobApplicationDAO.get();
            jobApplicationRepository.delete(deletedDao);
        } else {
            throw new ApplicationNotFoundException("Job Not Found");
        }
    }

    @Override
    public List<JobApplicationDTO> getAllJobApplications(Integer userId) {
        Optional<List<JobApplicationDAO>> daos = jobApplicationRepository.findByUserUserId(userId);
        List<JobApplicationDTO> jobApplicationDTOS = new ArrayList<>();
        if(daos.isPresent()) {
            daos.get().forEach((dao) -> jobApplicationDTOS.add(JobApplicationMapper.mapJobApplicationDTO(dao)));
        }
        return jobApplicationDTOS;
    }


}
