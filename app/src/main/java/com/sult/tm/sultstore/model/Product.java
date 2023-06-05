package com.sult.tm.sultstore.model;

public class Product {

    int id, filter, price;
    String img, fulImg, title, text, spec;
    Boolean fave;

    public Product(int id, int filter, int price, String img, String fulImg, String title, String text, String spec, Boolean fave) {
        this.id = id;
        this.img = img;
        this.fulImg = fulImg;
        this.title = title;
        this.price = price;
        this.text = text;
        this.spec = spec;
        this.fave = fave;
        this.filter = filter;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFilter() {
        return filter;
    }

    public void setFilter(int filter) {
        this.filter = filter;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getFulImg() {
        return fulImg;
    }

    public void setFulImg(String fulImg) {
        this.fulImg = fulImg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public Boolean getFave() {
        return fave;
    }

    public void setFave(Boolean fave) {
        this.fave = fave;
    }
}