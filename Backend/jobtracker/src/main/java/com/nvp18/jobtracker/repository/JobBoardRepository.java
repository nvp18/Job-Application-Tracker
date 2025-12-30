package com.nvp18.jobtracker.repository;

import com.nvp18.jobtracker.dao.JobBoardDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobBoardRepository extends JpaRepository<JobBoardDao, String> {

}
