package com.example.security.model;

public class Student {

    private int sid;
    private String sname;
    private String smarks;

    public Student() {
    }

    public Student(int sid, String sname, String smarks) {
        this.sid = sid;
        this.sname = sname;
        this.smarks = smarks;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSmarks() {
        return smarks;
    }

    public void setSmarks(String smarks) {
        this.smarks = smarks;
    }
}