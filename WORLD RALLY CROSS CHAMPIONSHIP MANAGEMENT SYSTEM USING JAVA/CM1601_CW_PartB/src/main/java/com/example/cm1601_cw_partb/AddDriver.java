package com.example.cm1601_cw_partb;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Paint;

import java.util.ArrayList;

public class AddDriver {

    public void addDriver(TextField name, TextField age, TextField team, TextField car, TextField points, Label error, ArrayList<Driver> drivers) {


        String driverName, driverTeam, driverCar;
        int driverAge, driverPoints;

        error.setText("");
        error.setTextFill(Paint.valueOf("#FF3A3A"));

        driverName = name.getText();
        driverName = driverName.replaceAll("\\s+", "_").toLowerCase();
        if (isIntAge(age, error)){
            driverAge = Integer.parseInt(age.getText());
        }else {
            return;
        }
        driverTeam = team.getText();
        driverTeam = driverTeam.replaceAll("\\s+", "_").toLowerCase();
        driverCar = car.getText();
        driverCar = driverCar.replaceAll("\\s+", "_").toLowerCase();
        if (isIntPoints(points, error)){
            driverPoints = Integer.parseInt(points.getText());
        }else {
            return;
        }

        if (name.getText().equals("") || age.getText().equals("") || team.getText().equals("") || car.getText().equals("") || points.getText().equals("")){
            error.setText("Please Fill All The Fields");
        }else {
            Driver newDriver = new Driver(driverName, driverAge, driverTeam, driverCar, driverPoints);
            Driver driver;
            for (int i = 0; i < drivers.size(); i++){
                driver = drivers.get(i);
                if (driver.compare(newDriver, driver)){
                    error.setText(driverName + " already exists");
                    return;
                }
            }
            drivers.add(newDriver);
            error.setText(driverName + " Added!");
        }
    }

    private boolean isIntAge(TextField input, Label label){
        try {
            int driverAge = Integer.parseInt(input.getText());
            return true;
        }catch (NumberFormatException e){
            label.setText("Age should be a number. Please check your details");
            return false;
        }
    }

    private boolean isIntPoints(TextField input, Label label){
        try {
            int driverAge = Integer.parseInt(input.getText());
            return true;
        }catch (NumberFormatException e){
            label.setText("Current Points should be a number. Please check your details");
            return false;
        }
    }


}
