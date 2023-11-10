package com.example.cm1601_cw_partb;

import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static com.example.cm1601_cw_partb.SceneController.races;

public class RandomRace {
    String location, date;
    private String[] locations = {"Nyirád", "Höljes", "Montalegre", "Barcelona", "Rīga", "Norway"};

    public void randomRace(TextField date, Label error, ArrayList<Driver> drivers, TableView<Driver> standingsTable, TableColumn<Driver, String> standingsName, TableColumn<Driver, Integer> standingsAge, TableColumn<Driver, String> standingsTeam, TableColumn<Driver, String> standingsCar, TableColumn<Driver, Integer> standingsPoints){
        int first, second, third, dd, mm, yy, max1;
        String dateS = date.getText();
        String[] dateSplit = dateS.split("/");

        dd = Integer.parseInt(dateSplit[0]);
        mm = Integer.parseInt(dateSplit[1]);
        yy = Integer.parseInt(dateSplit[2]);

        if (mm == 1 || mm == 3 || mm == 5 || mm == 7 || mm == 8 || mm == 10 || mm == 12){
            max1 = 31;
        }
        else if (mm == 4 || mm == 6 || mm == 9 || mm == 11) {
            max1 = 30;
        }
        else if (yy % 4 == 0 && yy % 100 != 0 || yy % 400 == 0) {
            max1 = 29;
        }
        else {
            max1 = 28;
        }

        if (mm < 1 || mm > 12){
            error.setText("Invalid date");
            return;
        }
        else if (dd < 1 || dd > max1) {
            error.setText("Invalid Date");
            return;
        }


        Random rand = new Random();
        int locationIndex = rand.nextInt(locations.length);
        location = locations[locationIndex];

        error.setText("Date: " + dateS + "\n" +
                "Location: " + location);

        Collections.shuffle(drivers);

        first = drivers.get(0).getCurrentPoints();
        second = drivers.get(1).getCurrentPoints();
        third = drivers.get(2).getCurrentPoints();

        first = first + 10;
        second = second + 7;
        third = third + 5;

        drivers.get(0).setCurrentPoints(first);
        drivers.get(1).setCurrentPoints(second);
        drivers.get(2).setCurrentPoints(third);


        standingsName.setCellValueFactory(new PropertyValueFactory<>("name"));
        standingsAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        standingsTeam.setCellValueFactory(new PropertyValueFactory<>("team"));
        standingsCar.setCellValueFactory(new PropertyValueFactory<>("car"));
        standingsPoints.setCellValueFactory(new PropertyValueFactory<>("currentPoints"));

        for (Driver driver: drivers){
            standingsTable.getItems().add(driver);
        }

        String[] driverPos = new String[drivers.size()];

        for (int i = 0; i < drivers.size(); i++){
            driverPos[i] = drivers.get(i).getName();
        }

        Race newRace = new Race(dateS, location);
        races.add(newRace);

    }
}
