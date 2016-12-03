/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.mziuri.restaraunt.dao;

import ge.mziuri.restaraunt.enums.FoodType;
import ge.mziuri.restaraunt.metainfo.DataBaseMetaInfo;
import ge.mziuri.restaraunt.model.Food;
import ge.mziuri.restaraunt.model.Menu;
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
public class MenuDAOImpl implements MenuDAO{
    
    private Connection con;
    
    private PreparedStatement pstmt;
    
    public MenuDAOImpl() {
        try {
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(DataBaseMetaInfo.databaseURL, DataBaseMetaInfo.username, DataBaseMetaInfo.password);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void addMenu(Menu menu) {
        try{
            pstmt = con.prepareStatement("INSERT INTO menu(id, sale) VALUES (?,?)");
            pstmt.setInt(1, menu.getId());
            pstmt.setDouble(2, menu.getSale());
            pstmt.executeUpdate();
            
            for (Food food : menu.getFoodList()) {
                pstmt = con.prepareStatement("INSERT INTO menu_food VALUES (?,?)");
                pstmt.setInt(1, menu.getId());
                pstmt.setInt(2, food.getId());
                pstmt.executeUpdate();
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Menu> seeAllMenu() {
        List<Menu> menus = new ArrayList<>();
        try {
            pstmt = con.prepareStatement("SELECT * FROM menu");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int ID = rs.getInt("id");
                Double Sale = rs.getDouble("sale");
                Menu menu = new Menu(ID,seeFoodsByMenuID(ID) ,Sale);
                menus.add(menu);
            } 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return menus;
    }

    @Override
    public List<Food> seeFoodsByMenuID(int menuID) {
        List<Food> foods = new ArrayList<>();
        try {
            pstmt = con.prepareStatement("SELECT * FROM food WHERE id IN (SELECT food_id FROM menu_food WHERE menu_id = ?)");
            pstmt.setInt(1, menuID);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int ID = rs.getInt("id");
                String Name = rs.getString("name");
                FoodType foodType = FoodType.valueOf(rs.getString("type"));
                Double Price = rs.getDouble("price");
                int Rating = rs.getInt("rating_sum");
                Food food = new Food(ID, Name, foodType, Price, Rating);
                foods.add(food);
            } 
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return foods;
    }
    
}
