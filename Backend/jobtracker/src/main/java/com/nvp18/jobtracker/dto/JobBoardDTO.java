package com.nvp18.jobtracker.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobBoardDTO {

    private String atsId;
    private String name;
    private String baseUrl;
    private Boolean requiresAuth;
    private Boolean hasJobUrl;
    private String jobUrl;

}
