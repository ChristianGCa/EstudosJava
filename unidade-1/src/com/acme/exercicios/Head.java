package com.acme.exercicios;

import java.util.Date;
import java.util.UUID;

public class Head {

    // Atributos
    private UUID id;
    private int priority;
    private String type;
    private Date creationDate;
    
    // Operações

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    
    
    
}
