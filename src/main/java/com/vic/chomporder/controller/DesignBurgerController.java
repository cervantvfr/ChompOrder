package com.vic.chomporder.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.vic.chomporder.model.Burger;
import com.vic.chomporder.model.Ingredient;
import com.vic.chomporder.model.Order;
import com.vic.chomporder.model.Ingredient.Type;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("chompOrder")
public class DesignBurgerController {
    
    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
            new Ingredient("BEF", "Beef", Type.PROTEIN),
            new Ingredient("IMP", "Impossible Burger", Type.PROTEIN),
            new Ingredient("CKN", "Chicken", Type.PROTEIN),
            new Ingredient("FSH", "Fish", Type.PROTEIN),
            new Ingredient("TMT", "Tomato", Type.VEGGIES),
            new Ingredient("LTC", "Lettuce", Type.VEGGIES),
            new Ingredient("PKL", "Pickles", Type.VEGGIES),
            new Ingredient("ONI", "Onion", Type.VEGGIES),
            new Ingredient("EMT", "Emmental", Type.CHEESE),
            new Ingredient("GRY", "Gruyere", Type.CHEESE),
            new Ingredient("CMT", "Comte", Type.CHEESE),
            new Ingredient("GDA", "Gouda", Type.CHEESE),
            new Ingredient("AMR", "American", Type.CHEESE),
            new Ingredient("KCH", "Ketchup", Type.SAUCE),
            new Ingredient("MAY", "Mayo", Type.SAUCE),
            new Ingredient("MST", "Mustard", Type.SAUCE),
            new Ingredient("BBQ", "Barbecue", Type.SAUCE)
        );

        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
    }

    @ModelAttribute(name = "chompOrder")
    public Order order() {
        return new Order();
    }

    @ModelAttribute(name = "burger")
    public Burger burger() {
        return new Burger();
    }

    @GetMapping
    public String showDesignForm() {
        return "design";
    }
    

    private Object filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
