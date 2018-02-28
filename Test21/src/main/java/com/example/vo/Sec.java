package com.example.vo;

public class Sec {
	public int id;
	private int rootid;
	private int ord;
	private int p;
	public String title;
	public String content;
	public String wrt;
	public String pass;
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
    public int getRootid() {
    	return rootid;
    }
    public void setRootid(int rootid) {
        this.rootid = rootid;
    }
    public int getOrd() {
    	return ord;
    }
    public void setOrd(int ord) {
        this.ord = ord;
    }
    public int getP() {
    	return p;
    }
    public void setP(int p) {
        this.p = p;
    }
    public String getTitle() {
    	return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
    	return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getWrt() {
    	return wrt;
    }
    public void setWrt(String wrt) {
        this.wrt = wrt;
    }
    public String getPass() {
    	return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
}
