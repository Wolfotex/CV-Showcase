package com.example.cm1601_cw_partb;

public class Race {
    private String date;
    private String location;

    public Race(String date, String location){
        this.date = date;
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }
}
