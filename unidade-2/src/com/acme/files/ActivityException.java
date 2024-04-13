package com.acme.files;

import java.util.Date;

public class ActivityException extends RuntimeException {
    
    private Date executionFailureDate;
    
    public ActivityException(String msg) {
        
        // super se refere a superclasse, ou seja, RuntimeException, nesse caso
        super( msg );
        executionFailureDate = new Date();
    }
    
    // Sobrescreve o método "getMessage()" da classe "RuntimeException"
    @Override
    public String getMessage() {
        return executionFailureDate.toString() + "\n" + super.getMessage();
    }
    
}
