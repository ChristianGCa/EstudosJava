package com.acme;

import java.util.Date;

public class ActivityException extends Exception {
    
    private Date executionFailureDate;
    
    public ActivityException(String msg) {
        super( msg );
        executionFailureDate = new Date();
    }
    
    @Override
    public String getMessage() {
        return executionFailureDate.toString() + "\n" + super.getMessage();
    }
    
}
