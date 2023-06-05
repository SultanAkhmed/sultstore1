package com.sult.tm.sultstore.model;

public class New {

    int id;
    String img, title, desc, pageDesc, text;

    public New(int id, String img, String title, String desc, String text, String pageDesc){
        this.id = id;
        this.img = img;
        this.title = title;
        this.desc = desc;
        this.text = text;
        this.pageDesc = pageDesc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPageDesc() {
        return pageDesc;
    }

    public void setPageDesc(String pageDesc) {
        this.pageDesc = pageDesc;
    }
}
