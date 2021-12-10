package com.engeto.urm.dto;

import java.util.Random;
import java.util.UUID;

public class Cargo {
    private UUID id;
    private String description;
    private Integer weight;
    private Integer totalPrice;

    public Cargo() {
    }

    public UUID getId() {
        return id;
    }

    public void setId() {
        this.id = UUID.randomUUID();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = (weight / 100)*100;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", weight=" + weight +
                ", totalPrice=" + totalPrice +
                '}' + "\n";
    }
}

