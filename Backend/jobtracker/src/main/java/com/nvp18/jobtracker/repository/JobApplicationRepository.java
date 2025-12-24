package com.nvp18.jobtracker.repository;

import com.nvp18.jobtracker.dao.JobApplicationDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobApplicationRepository  extends JpaRepository<JobApplicationDAO,String> {

}
