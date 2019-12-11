package com.example.android;

public class Cat {
    /**
     * 名字
     */
    private String name;

    /**
     * 图片 ID
     */
    private int imageId;

    public Cat(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}