/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.mziuri.restaraunt.dao;

import ge.mziuri.restaraunt.model.Menu;
import java.util.List;

/**
 *
 * @author Archil
 */
public interface MenuDAO {
    void addMenu(Menu menu);
    List<Menu> seeAllMenu();
    void deleteMenu(int menuID);
}
