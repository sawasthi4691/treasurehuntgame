package com.treasure.hunt.game.model;

import java.util.Date;

/**
 * Exception Response class
 * To show exception message if occurred in response API.
 */
public class ExceptionResponse {

    private final Date timestamp;
    private final String message;
    private final String details;

    public ExceptionResponse(Date timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

}
