package com.example.cm1601_cw_partb;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class UpdateDriver {
    public void updateDriverP1(TextField updateName, ArrayList<Driver> drivers, Driver updatingDriver, Label error, TextField name, TextField age, TextField team, TextField car, TextField points){
        String driverName, driverTeam, driverCar;
        int driverAge, driverPoints;

        error.setText("");
        String driverUpdateName = updateName.getText();
        driverUpdateName = driverUpdateName.replaceAll("\\s+", "_").toLowerCase();

        for (int i = 0; i < drivers.size(); i++){
            if (drivers.get(i).getName().equals(driverUpdateName)){
                updatingDriver = drivers.get(i);
                drivers.remove(i);
                error.setText(updatingDriver.getName() + " Found");
            }
        }

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
            Driver updatedDriver = new Driver(driverName, driverAge, driverTeam, driverCar, driverPoints);
            drivers.add(updatedDriver);
            error.setText(driverName + " updated!");
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
