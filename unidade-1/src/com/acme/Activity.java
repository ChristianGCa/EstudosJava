package com.acme;

import java.util.Date;
import java.util.UUID;

public class Activity {

    // Atributes
    private UUID id;
    // acesso por pacote e por herança
    protected String name;
    private Date executionDate;
    private Priority priority;
    
    // Enumeration
    enum Priority {
        LOWEST, LOW, NORMAL, HIGH, HIGHEST;
    }
    
    // Constructor
    public Activity() {
        this.id = UUID.randomUUID();
    }
    
    public Activity(String name) {
        this();
        this.setName(name);        
    }
    
    // Operations
    
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() >= 4 && name.length() <= 8) {
            this.name = name;
        }
    }

    public Date getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(Date executionDate) {
        this.executionDate = executionDate;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
    
    
    
}
