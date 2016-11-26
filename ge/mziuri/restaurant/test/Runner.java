/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.mziuri.restaurant.test;

import ge.mziuri.restaraunt.dao.FoodDAO;
import ge.mziuri.restaraunt.dao.FoodDAOImpl;
import ge.mziuri.restaraunt.dao.MenuDAO;
import ge.mziuri.restaraunt.dao.MenuDAOImpl;
import ge.mziuri.restaraunt.dao.ReviewDAO;
import ge.mziuri.restaraunt.dao.ReviewDAOImpl;
import ge.mziuri.restaraunt.enums.FoodType;
import ge.mziuri.restaraunt.model.Food;
import ge.mziuri.restaraunt.model.FoodReview;
import ge.mziuri.restaraunt.model.Menu;
import ge.mziuri.restaraunt.model.Review;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author User
 */
public class Runner {
    
    public static void main(String[] args) {
        
        FoodDAO foodDAO = new FoodDAOImpl();
        ReviewDAO reviewDAO = new ReviewDAOImpl();
        MenuDAO menuDAO = new MenuDAOImpl();
        
        Food food1 = new Food(1, "becon", FoodType.Food, 5, 0);
        Food food2= new Food(2, "eggs", FoodType.Food, 3, 0);
        Food food3 = new Food(3, "wine", FoodType.Beverage, 40, 0);
        Food food4 = new Food(4, "bread", FoodType.Food, 3.5, 0);
        Food food5 = new Food(5, "button", FoodType.Food, 2, 0);
        Food food6 = new Food(6, "tes", FoodType.Beverage, 5, 0);
//        
//        foodDAO.addFood(food1);
//        foodDAO.addFood(food2);
//        foodDAO.addFood(food3);
//        foodDAO.addFood(food4);
//        foodDAO.addFood(food5);
//        foodDAO.addFood(food6);
//        
//        System.out.println(foodDAO.getAllDrink());
//        System.out.println(foodDAO.getAllFood());
        
//        Review review1 = new Review(7, 1, 10, "best");
//        Review review2 = new Review(8, 1, 8, "best");
//        Review review3 = new Review(9, 2, 9, "best");
//        
//        reviewDAO.addReview(review1);
//        reviewDAO.addReview(review2);
//        reviewDAO.addReview(review3);

//        List<FoodReview> r = reviewDAO.getFoodReviews("becon");
//        System.out.println(r);
        
        
        Menu menu1 = new Menu(1, new ArrayList<Food>(Arrays.asList(food1, food2)), 50);
        menuDAO.addMenu(menu1);
        
    }
    
}
