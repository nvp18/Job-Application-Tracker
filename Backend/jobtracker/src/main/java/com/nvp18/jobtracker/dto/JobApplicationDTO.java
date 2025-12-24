package com.nvp18.jobtracker.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobApplicationDTO {

    private String jobId;
    private String jobTitle;
    private String companyName;
    private String jobLink;
    private LocalDateTime appliedDate;
    private String status;
    private String source;
    private String jobType;
    private String location;

}
