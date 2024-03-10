package com.acme.exercicios;

import java.util.UUID;

public class Head {
    
    // Atributes
    private UUID id;
    private int priority;
    private String type;
    private Boolean creationDate;
    
    // Operations

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

    public Boolean getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Boolean creationDate) {
        this.creationDate = creationDate;
    }
    
}
