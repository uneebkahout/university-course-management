package com.example.ucms.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiSuccessResponse {
    private int status;
    private String message;
    private String path;
}