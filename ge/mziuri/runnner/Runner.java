package ge.mziuri.runnner;

import ge.mziuri.restaraunt.dao.ReviewDAO;
import ge.mziuri.restaraunt.dao.ReviewDAOImpl;
import ge.mziuri.restaraunt.model.Review;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Review review = new Review(2, 3, 10, "Very good");
        ReviewDAO review1 = new ReviewDAOImpl();
        
        review1.seeTodaysReviews();
       
    }
}
