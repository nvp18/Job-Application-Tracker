package com.nvp18.jobtracker.dao;

import com.nvp18.jobtracker.constants.ApplicationStatus;
import com.nvp18.jobtracker.constants.JobType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "jobapplications")
public class JobApplicationDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "jobId")
    private String jobId;

    @Column(name = "jobTitle", nullable = false)
    private String jobTitle;

    @Column(name = "companyName", nullable = false)
    private String companyName;

    @Column(name = "jobLink", nullable = false)
    private String jobLink;

    @Column(name = "appliedDate", nullable = false)
    private LocalDateTime appliedDate;

    @Enumerated(EnumType.STRING)
    @Column(name="status", nullable = false)
    private ApplicationStatus status;

    @Column(name = "source", nullable = false)
    private String source;

    @Enumerated(EnumType.STRING)
    @Column(name="jobType",nullable = false)
    private JobType jobType;

    @Column(name="location",nullable = false)
    private String location;

}
