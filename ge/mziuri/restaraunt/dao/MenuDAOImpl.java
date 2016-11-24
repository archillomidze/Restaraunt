/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.mziuri.restaraunt.dao;

import ge.mziuri.restaraunt.metainfo.DataBaseMetaInfo;
import ge.mziuri.restaraunt.model.Menu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
            pstmt = con.prepareStatement("INSERT INTO menu(id, sale)");
            pstmt.setInt(1, menu.getId());
            pstmt.setDouble(2, menu.getSale());
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Menu> seeAllMenu() {
    }

    @Override
    public void deleteMenu(int menuID) {
        
    }
    
}
