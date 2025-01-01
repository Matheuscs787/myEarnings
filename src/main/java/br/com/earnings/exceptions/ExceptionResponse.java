package br.com.earnings.exceptions;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionResponse implements Serializable {

    private String timestamp;
    private String message;
    private String details;

    public ExceptionResponse(Date timestamp, String message, String details) {
        this.timestamp = formatDate(timestamp);
        this.message = message;
        this.details = details;
    }

    private String formatDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return formatter.format(date);
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
