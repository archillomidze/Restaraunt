/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.mziuri.restaraunt.dao;

import ge.mziuri.restaraunt.model.FoodReview;
import ge.mziuri.restaraunt.model.Review;
import java.util.List;

/**
 *
 * @author Archil
 */
public interface ReviewDAO {
    
    public void addReview(Review review);    
    
    public List<FoodReview> getTodaysReviews();
    
    public List<FoodReview> getFoodReviews(String foodName);
    
}
