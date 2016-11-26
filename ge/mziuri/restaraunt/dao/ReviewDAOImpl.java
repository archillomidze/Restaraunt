/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.mziuri.restaraunt.dao;

import ge.mziuri.restaraunt.metainfo.DataBaseMetaInfo;
import ge.mziuri.restaraunt.model.FoodReview;
import ge.mziuri.restaraunt.model.Review;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import java.util.List;

public class ReviewDAOImpl implements ReviewDAO {

    private Connection con;

    private PreparedStatement pstmt;

    public ReviewDAOImpl() {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(DataBaseMetaInfo.databaseURL, DataBaseMetaInfo.username, DataBaseMetaInfo.password);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void addReview(Review review) {
        try {
            pstmt = con.prepareStatement("INSERT INTO REVIEW (id, food_id, rating, comment, date) VALUES (?,?,?,?,?)");
            pstmt.setInt(1, review.getId());
            pstmt.setInt(2, review.getFood_id());
            pstmt.setInt(3, review.getRating());
            pstmt.setString(4, review.getComment());
            java.util.Date utilDate = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            pstmt.setDate(5, sqlDate);
            pstmt.executeUpdate();
            
            pstmt = con.prepareStatement("UPDATE food SET rating_sum = rating_sum + " + review.getRating() + " WHERE id = ?");
            pstmt.setInt(1, review.getFood_id());
            System.out.println(review.getRating());
            System.out.println(review.getFood_id());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public List<FoodReview> getTodaysReviews() {
        List<FoodReview> reviews = new ArrayList<>();
        try {
            pstmt = con.prepareStatement("SELECT food.name ,review.comment,review.rating FROM FOOD INNER JOIN review ON food.id = review.food_id WHERE review.date = current_date");

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                String name = rs.getString("name");
                String comment = rs.getString("comment");
                int rating = rs.getInt("rating");
                FoodReview fr = new FoodReview(name, comment, rating);
                reviews.add(fr);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return reviews;
    }

    @Override
    public List<FoodReview> getFoodReviews(String foodName) {
        List<FoodReview> reviews = new ArrayList<>();
        try {
            pstmt = con.prepareStatement(" SELECT food.name ,review.comment,review.rating FROM FOOD INNER JOIN review ON food.id = review.food_id WHERE food.name = (?)");

            pstmt.setString(1, foodName);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                String name = rs.getString("name");
                String comment = rs.getString("comment");
                int rating = rs.getInt("rating");
                FoodReview fr = new FoodReview(name, comment, rating);
                reviews.add(fr);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return reviews;
    }

}
