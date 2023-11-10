package com.example.cm1601_cw_partb;

public class Driver
{
    private String name;
    private int age;
    private String team;
    private String car;
    private int currentPoints;

    public Driver(String name, int age, String team, String car, int currentPoints) {
        this.name = name;
        this.age = age;
        this.team = team;
        this.car = car;
        this.currentPoints = currentPoints;
    }
    // Getter methods for the fields
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getTeam() {
        return team;
    }

    public String getCar() {
        return car;
    }

    public int getCurrentPoints() {
        return currentPoints;
    }

    // Setter methods for the fields
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public void setCurrentPoints(int currentPoints) {
        this.currentPoints = currentPoints;
    }

    public boolean compare(Driver driver1, Driver driver2){
        return driver1.name.equals(driver2.name) && driver1.age == driver2.age && driver1.team.equals(driver2.team);
    }
}
