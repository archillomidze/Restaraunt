/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.mziuri.restaraunt.model;

import java.util.Date;

/**
 *
 * @author Archil
 */
public class Review {
    
    private int id;

    private int food_id;

    private int rating;

    private String comment;

    private Date date;

    public Review() {
    }

    public Review(int id, int food_id, int rating, String comment, Date date) {
        this.id = id;
        this.food_id = food_id;
        this.rating = rating;
        this.comment = comment;
        this.date = date;
    }

    public Review(int id, int food_id, int rating, String comment) {
        this.id = id;
        this.food_id = food_id;
        this.rating = rating;
        this.comment = comment;
    }

    public Review(int food_id, int rating, String comment, Date date) {
        this.food_id = food_id;
        this.rating = rating;
        this.comment = comment;
        this.date = date;
    }
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFood_id() {
        return food_id;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Review{" + "id=" + id + ", food_id=" + food_id + ", rating=" + rating + ", comment=" + comment + ", date=" + date + '}';
    }
    
    
    
}
