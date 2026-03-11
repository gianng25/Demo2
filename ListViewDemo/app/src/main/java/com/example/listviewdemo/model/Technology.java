package com.example.listviewdemo.model;

public class Technology {
    private int img;
    private String name,sub,describe;

    public Technology(Integer img, String name, String sub, String desc) {
        this.img = img;
        this.name = name;
        this.sub = sub;
        this.describe = desc;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}

