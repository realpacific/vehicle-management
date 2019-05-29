package com.realpacific.vehiclemanagement.exceptions;

public class AuthenticationException extends RuntimeException {
    public AuthenticationException() {
        super("Username/password mismatch.");
    }
}
