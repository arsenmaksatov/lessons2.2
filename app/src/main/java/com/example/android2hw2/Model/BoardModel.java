package com.example.android2hw2.Model;

public class BoardModel {
    private int image;
    private String description;


    public int getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }



    public BoardModel(int image, String description) {
        this.image = image;
        this.description = description;
    }
}
