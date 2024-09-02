package com.workintech.s18d1.util;

import com.workintech.s18d1.entity.Burger;
import com.workintech.s18d1.entity.BreadType;

public class BurgerValidation {

    public static void validateBurger(Burger burger) {
        if (burger.getName() == null || burger.getName().isEmpty()) {
            throw new IllegalArgumentException("Burger name cannot be empty");
        }
        if (burger.getPrice() < 0) {
            throw new IllegalArgumentException("Burger price cannot be negative");
        }
        validateBreadType(burger.getBreadType());
        if (burger.getContents() == null || burger.getContents().isEmpty()) {
            throw new IllegalArgumentException("Burger content cannot be empty");
        }
    }

    public static void validateId(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Burger ID must be positive");
        }
    }

    private static void validateBreadType(BreadType breadType) {
        if (breadType == null) {
            throw new IllegalArgumentException("Burger bread type cannot be null");
        }
    }
}
