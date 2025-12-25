package com.nvp18.jobtracker.dto;

import com.nvp18.jobtracker.constants.ApplicationStatus;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateStatusDTO {

    private ApplicationStatus status;
}
