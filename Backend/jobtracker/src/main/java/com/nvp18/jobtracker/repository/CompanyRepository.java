package com.nvp18.jobtracker.repository;

import com.nvp18.jobtracker.dao.CompanyDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<CompanyDao, String> {


}
