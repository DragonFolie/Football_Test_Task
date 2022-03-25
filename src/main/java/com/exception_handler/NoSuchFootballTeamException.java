package com.exception_handler;

public class NoSuchFootballTeamException extends RuntimeException{
    public NoSuchFootballTeamException(String message) {
        super(message);
    }
}
