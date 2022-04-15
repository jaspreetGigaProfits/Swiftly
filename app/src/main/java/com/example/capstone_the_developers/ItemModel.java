package com.example.capstone_the_developers;

public class ItemModel {
    private int image;
    private String name, planDesc, author;

    public ItemModel() {
    }

    public ItemModel(int image, String name, String planDesc, String author) {
        this.image = image;
        this.name = name;
        this.planDesc = planDesc;
        this.author = author;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getPlanDesc() {
        return planDesc;
    }

    public String getAuthor() {
        return author;
    }
}
