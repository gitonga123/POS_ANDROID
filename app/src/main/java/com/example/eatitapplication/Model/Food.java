package com.example.eatitapplication.Model;

/**
 * Created by otbafrica on 2/7/18.
 */

public class Food {
    private  String name, description,image, price, discount,menuId;

    public Food() {
    }

    public Food(String name, String description, String image, String price, String discount, String menuId) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
        this.discount = discount;
        this.menuId = menuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }
}
