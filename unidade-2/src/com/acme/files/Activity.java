package com.acme.files;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

// Os objetos dessa classe podem ser serializados (convertidos em bytes para armazenamento ou transmissão)
public class Activity implements Serializable{

    // Atributes
    private UUID id;
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
    
    public Activity(String name) throws ActivityException {
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

    public void setName(String name) throws ActivityException {
        if (name.length() >= 4 && name.length() <= 16) {
            this.name = name;
        }else {
            ActivityException ex = new ActivityException("Falha ao criar a atividade. Nome fora do limite de caracteres!");
            throw ex;
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