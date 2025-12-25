package com.nvp18.jobtracker.exception;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserNotFoundException extends RuntimeException{

    private String message;

}
