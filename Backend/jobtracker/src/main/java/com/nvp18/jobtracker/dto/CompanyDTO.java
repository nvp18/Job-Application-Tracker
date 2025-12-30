package com.nvp18.jobtracker.dto;

import com.nvp18.jobtracker.dao.JobBoardDao;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDTO {

    private String companyId;

    private String companyName;

    private String companySlug;

}
