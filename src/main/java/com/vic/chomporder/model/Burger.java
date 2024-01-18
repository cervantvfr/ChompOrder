package com.vic.chomporder.model;

import lombok.Data;
import java.util.List;

@Data
public class Burger {
    private List<Ingredient> ingredients;
}
