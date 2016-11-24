/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.mziuri.restaraunt.dao;

import ge.mziuri.restaraunt.metainfo.DataBaseMetaInfo;
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
            pstmt.executeQuery();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public List<Review> seeTodaysReviews() {
        List<Review> reviews = new ArrayList<>();
        try {
            pstmt = con.prepareStatement("SELECT * FROM REVIEW WHERE date = (?) ");
            
            java.util.Date utilDate = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            pstmt.setDate(1, sqlDate);
            System.out.println(sqlDate);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                int id = rs.getInt("id");
                int food_id = rs.getInt("food_id");
                int rating = rs.getInt("rating");
                String commnet = rs.getString("comment");
                Date date = rs.getDate("date");
                
                Review review = new Review(id, food_id, rating, commnet,date);
                reviews.add(review);
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return reviews;
    }

    @Override
    public List<Review> seeFoodReviews() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
