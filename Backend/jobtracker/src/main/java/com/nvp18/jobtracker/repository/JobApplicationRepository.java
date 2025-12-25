package com.nvp18.jobtracker.repository;

import com.nvp18.jobtracker.dao.JobApplicationDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobApplicationRepository  extends JpaRepository<JobApplicationDAO,Integer> {

    Optional<List<JobApplicationDAO>> findByUserUserId(Integer userId);
}
