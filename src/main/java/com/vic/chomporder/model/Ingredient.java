package com.vic.chomporder.model;

import lombok.Data;

@Data
public class Ingredient {
    
    private final String id;
    private final String name;
    private final Type type;

    public enum Type {
        PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
