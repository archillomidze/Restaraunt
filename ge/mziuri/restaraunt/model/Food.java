/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.mziuri.restaraunt.model;

import ge.mziuri.restaraunt.enums.FoodType;

/**
 *
 * @author Archil
 */
public class Food {
    
    private int id;

    private String name;

    private FoodType foodType;

    private double price;

    private int rating_sum;

    public Food() {
    }

    public Food(int id, String name, FoodType foodType, double price, int rating_sum) {
        this.id = id;
        this.name = name;
        this.foodType = foodType;
        this.price = price;
        this.rating_sum = rating_sum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRating_sum() {
        return rating_sum;
    }

    public void setRating_sum(int rating_sum) {
        this.rating_sum = rating_sum;
    }

    @Override
    public String toString() {
        return "Food{" + "id=" + id + ", name=" + name + ", foodType=" + foodType + ", price=" + price + ", rating_sum=" + rating_sum + '}';
    }
    
}
