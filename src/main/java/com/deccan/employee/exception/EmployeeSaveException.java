package com.deccan.employee.exception;

public class EmployeeSaveException extends RuntimeException {

    public EmployeeSaveException(String message, Throwable cause) {
        super(message, cause);
    }
}
