package com.example.cm1601_cw_partb;


import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


import java.util.ArrayList;

public class DeleteDriver {
    public void deleteDriver(TextField name, ArrayList<Driver> drivers, Label error){
        Driver deleteDriver;
        String driverDeleteName = name.getText();
        error.setText("");
        driverDeleteName = driverDeleteName.replaceAll("\\s+", "_").toLowerCase();
        for (int i = 0; i < drivers.size(); i++){
            if (drivers.get(i).getName().equals(driverDeleteName)){
                deleteDriver = drivers.get(i);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Are you sure?");
                alert.setHeaderText("You're about to delete " + driverDeleteName);
                alert.setContentText("Driver name: " + deleteDriver.getName() +"\n" +
                        "Age: " + deleteDriver.getAge() + "\n" +
                        "Team: " + deleteDriver.getTeam());

                if (alert.showAndWait().get() == ButtonType.OK){
                    drivers.remove(i);
                    error.setText(driverDeleteName + " has been removed.");
                }

            }else {
                error.setText(driverDeleteName + " doesn't exist. Please Try again");
            }
        }
    }
}
