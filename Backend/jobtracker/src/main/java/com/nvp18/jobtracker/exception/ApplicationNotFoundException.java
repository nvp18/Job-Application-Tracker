package com.nvp18.jobtracker.exception;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplicationNotFoundException extends RuntimeException{

    private String message;

}
