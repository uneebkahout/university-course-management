package com.example.ucms.exception;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponseWithData<T> {
    private int status;
    private String error;
    private String message;
    private T data;
}
