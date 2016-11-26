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
            pstmt.setString(3, food.getFoodType().name());
            pstmt.setDouble(4, food.getPrice());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Food> getAllFood() {
        List<Food> foods = new ArrayList<>();
        try {
            pstmt = con.prepareStatement("SELECT * FROM food WHERE type = ?");
            pstmt.setString(1, FoodType.Food.name());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int ID = rs.getInt("id");
                String Name = rs.getString("name");
                Double Price = rs.getDouble("price");
                int Rating = rs.getInt("rating_sum");
                Food food = new Food(ID, Name, FoodType.Food, Price, Rating);
                foods.add(food);
            } 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return foods;
    }

    @Override
    public List<Food> getAllDrink() {
        List<Food> beverages = new ArrayList<>();
        try {
            pstmt = con.prepareStatement("SELECT * FROM food WHERE type = ?");
            System.out.println(FoodType.Beverage.name());
            pstmt.setString(1, FoodType.Beverage.name());
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int ID = rs.getInt("id");
                String Name = rs.getString("name");
                Double Price = rs.getDouble("price");
                int Rating = rs.getInt("rating_sum");
                Food Beverage = new Food(ID, Name, FoodType.Beverage, Price, Rating);
                beverages.add(Beverage);
            } 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return beverages;
    }
}
