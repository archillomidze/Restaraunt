
package ge.mziuri.Runner;

import ge.mziuri.restaraunt.dao.ReviewDAO;
import ge.mziuri.restaraunt.dao.ReviewDAOImpl;
import ge.mziuri.restaraunt.model.FoodReview;
import ge.mziuri.restaraunt.model.Review;
import java.util.List;


public class Runner {
    
    public static void main(String[] args) {
        Review review = new Review(5, 1, 10, "best");
        
        
        ReviewDAO review1 = new ReviewDAOImpl();
        List<FoodReview> r = review1.seeFoodReviews("XINKALI");
        System.out.println(r);
        
    }
    
}
