/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Image;
import javax.swing.JLabel;
import javax.swing.JTextField;


/**
 *
 * @author ADMIN
 */
public class Book {
    public String id;
    public String name;
    public int publish;
    public float price;
    private int number;
    public String category;
    private String img;
 
   
    /**
     *
     * @param id
     * @param name
     * @param publish
     * @param price
     * @param number
     * @param category
     * @param img
     * @param total
     */
    public Book(String id,String name, int publish, float price, int number, String category, String img) {
        super();
        this.id = id;
        this.name = name;
        this.publish = publish;
        this.price = price;
        this.number = number;
        this.category = category;
        this.img = img;
    }

    public Book() {
        super();
    }

    public Book(String id, String name, float price, int number) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
        this.number = number;
    }
    public String getId() {
        return id;
    }
    
    public void setId(String id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPublish() {
        return publish;
    }

    public void setPublish(int publish) {
        this.publish = publish;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
   }  
}
