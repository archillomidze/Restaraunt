/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.mziuri.restaraunt.model;

import java.util.List;

/**
 *
 * @author Archil
 */
public class Menu {
    
    private int id;

    private List<Food> foodList;

    private double sale;

    public Menu() {
    }

    public Menu(int id, List<Food> foodList, double sale) {
        this.id = id;
        this.foodList = foodList;
        this.sale = sale;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }

    public double getSale() {
        return sale;
    }

    public void setSale(double sale) {
        this.sale = sale;
    }

    @Override
    public String toString() {
        return "Menu{" + "id=" + id + ", foodList=" + foodList + ", sale=" + sale + '}';
    }

     
    
}
