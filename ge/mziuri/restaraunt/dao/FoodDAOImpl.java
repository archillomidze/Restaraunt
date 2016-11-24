/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.mziuri.restaraunt.dao;

import ge.mziuri.restaraunt.enums.FoodType;
import ge.mziuri.restaraunt.metainfo.DataBaseMetaInfo;
import ge.mziuri.restaraunt.model.Food;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Archil
 */
public class FoodDAOImpl implements FoodDAO{
    
    private Connection con;
    
    private PreparedStatement pstmt;
    
    public FoodDAOImpl() {
        try {
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(DataBaseMetaInfo.databaseURL, DataBaseMetaInfo.username, DataBaseMetaInfo.password);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void addFood(Food food) {
        try {
            pstmt = con.prepareStatement("INSERT INTO food (id,  name, type, price) VALUES (?,?,?,?);");
            pstmt.setInt(1, food.getId());
            pstmt.setString(2, food.getName());
            pstmt.setString(3, food.getFoodType().toString());
            pstmt.setDouble(4, food.getPrice());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Food> SeeAllFood(FoodType foodType) {
        List<Food> foods = new ArrayList<>();
        try {
            pstmt = con.prepareStatement("SELECT * FROM food WHERE type = ?");
            ResultSet rs = pstmt.executeQuery();
            pstmt.setString(1, foodType.toString());
            while (rs.next()) {
                int ID = rs.getInt("id");
                String Name = rs.getString("name");
                Double Price = rs.getDouble("price");
                int Rating = rs.getInt("rating");
                Food food = new Food(ID, Name, foodType, Price, Rating);
                foods.add(food);
            } 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return foods;
    }

    @Override
    public List<Food> SeeAllDrink(FoodType beverageType) {
        List<Food> beverages = new ArrayList<>();
        try {
            pstmt = con.prepareStatement("SELECT * FROM food WHERE type = ?");
            ResultSet rs = pstmt.executeQuery();
            pstmt.setString(1, beverageType.toString());
            while (rs.next()) {
                int ID = rs.getInt("id");
                String Name = rs.getString("name");
                Double Price = rs.getDouble("price");
                int Rating = rs.getInt("rating");
                Food Beverage = new Food(ID, Name, beverageType, Price, Rating);
                beverages.add(Beverage);
            } 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return beverages;
    }
}
