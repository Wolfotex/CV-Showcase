package com.example.cm1601_cw_partb;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SaveData {
    private Stage stage;
    private Scene scene;
    @FXML
    private BorderPane mainWindow;


    public void saveDataDriver(ArrayList<Driver> drivers, Label error){
        try {
            FileWriter myWriter = new FileWriter("src\\main\\resources\\com\\example\\cm1601_cw_partb\\data\\drivers.txt");
            String name, team, car;
            int age, points;
            for (int i = 0; i < drivers.size(); i++){
                name = drivers.get(i).getName();
                age = drivers.get(i).getAge();
                team = drivers.get(i).getTeam();
                car = drivers.get(i).getCar();
                points = drivers.get(i).getCurrentPoints();
                myWriter.write(name + " " + age + " " + team + " " + car + " " + points + "\n");
            }
            myWriter.close();
        } catch (IOException e) {
            error.setText("An error occurred.");
            e.printStackTrace();
        }
    }

    public void saveDataRaces(ArrayList<Race> races, Label error){
        try {
            FileWriter myWriter = new FileWriter("src\\main\\resources\\com\\example\\cm1601_cw_partb\\data\\races.txt");
            String[] names;
            String date, location;


            for (int i = 0; i < races.size(); i++){
                date = races.get(i).getDate();
                location = races.get(i).getLocation();
                myWriter.write(date + " " + location + " ");
                myWriter.write("\n");
            }

            myWriter.close();
        } catch (IOException e) {
            error.setText("An error occurred.");
            e.printStackTrace();
        }
    }

    public void loadDataDriver(ArrayList<Driver> drivers, Label error){
        try {
            String name, team, car;
            int age, points;
            File myObj = new File("src\\main\\resources\\com\\example\\cm1601_cw_partb\\data\\drivers.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] driverData = data.split(" ");
                name = driverData[0];
                age = Integer.parseInt(driverData[1]);
                team = driverData[2];
                car = driverData[3];
                points = Integer.parseInt(driverData[4]);
                Driver driver = new Driver(name, age, team, car, points);
                drivers.add(driver);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            error.setText("An error occurred.");
            e.printStackTrace();
        }
    }

    public void loadDataRaces(ArrayList<Race> races, Label error){
        try {
            String date, location;
            File myObj = new File("src\\main\\resources\\com\\example\\cm1601_cw_partb\\data\\races.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] race = data.split(" ");

                date = race[0];
                location = race[1];

                Race raceTemp = new Race(date, location);
                races.add(raceTemp);

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            error.setText("An error occurred.");
            e.printStackTrace();
        }
    }


    public void exit(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("You're about to exit");
        alert.setContentText("Do you want to exit the program?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) mainWindow.getScene().getWindow();
            stage.close();
        }
    }
}
