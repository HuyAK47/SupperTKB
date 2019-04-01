package com.example.huy.suppertkb;

public class Item {
    int id;
    String thu, mon, phong, tiet;

    public Item(int id, String thu, String mon, String phong, String tiet) {
        this.id = id;
        this.thu = thu;
        this.mon = mon;
        this.phong = phong;
        this.tiet = tiet;
    }

    public Item(String thu, String mon, String phong, String tiet) {
        this.thu = thu;
        this.mon = mon;
        this.phong = phong;
        this.tiet = tiet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getThu() {
        return thu;
    }

    public void setThu(String thu) {
        this.thu = thu;
    }

    public String getMon() {
        return mon;
    }

    public void setMon(String mon) {
        this.mon = mon;
    }

    public String getPhong() {
        return phong;
    }

    public void setPhong(String phong) {
        this.phong = phong;
    }

    public String getTiet() {
        return tiet;
    }

    public void setTiet(String tiet) {
        this.tiet = tiet;
    }
}
