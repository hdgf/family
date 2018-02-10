package com.universe.family.model.cronous.shop;

import javax.persistence.*;
import java.util.Date;

@Entity
public class WebNews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private int id;
    @Column(name="N_Name")
    private String name;
    @Column(name="N_Title")
    private String title;
    @Column(name="N_Info")
    private String info;
    @Column(name="N_Time")
    private Date time;
    @Column(name="N_Type")
    private String type;
    @Column(name="N_Top")
    private int top;
    @Column(name="N_Yn")
    private int yn;

    public WebNews() {
    }

    public WebNews(String name, String title, String info, Date time, String type, int top, int yn) {
        this.name = name;
        this.title = title;
        this.info = info;
        this.time = time;
        this.type = type;
        this.top = top;
        this.yn = yn;
    }

    public WebNews(String name, String title, String info, String type, int top, int yn) {
        this.name = name;
        this.title = title;
        this.info = info;
        this.type = type;
        this.top = top;
        this.yn = yn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getYn() {
        return yn;
    }

    public void setYn(int yn) {
        this.yn = yn;
    }
}
