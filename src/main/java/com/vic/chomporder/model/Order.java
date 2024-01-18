package com.vic.chomporder.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Order {
    
    private String id;
    private String deliveryDate;
    private String deliveryName;
    private String deliveryStreet;
    private String deliveryCity;
    private String deliveryZip;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;
    // private String orderTotal;

    private List<Burger> burgers = new ArrayList<Burger>();

    public void addBurger(Burger burger){
        this.burgers.add(burger);
    }

}
