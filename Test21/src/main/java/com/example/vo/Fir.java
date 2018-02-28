package com.example.vo;
 
public class Fir {
 
    private int id;
    private int viewcnt;
    private String title;
    private String date;
    private String wrt;
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
    
    public int getViewcnt() {
    	return viewcnt;
    }
    
    public void setViewcnt(int viewcnt) {
    	this.viewcnt=viewcnt;
    }
    public String getTitle() {
        return title;
    }
 
    public void setTitle(String title) {
        this.title = title;
    }
 
    public String getDate() {
        return date;
    }
 
    public void setDate(String date) {
        this.date = date;
    }
    public String getWrt() {
        return wrt;
    }
 
    public void setWrt(String wrt) {
        this.wrt = wrt;
    }
}