package com.nvp18.jobtracker.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplicationResponseDTO {

    private String message;
    private String error;
    private List<JobApplicationDTO> data;
}
