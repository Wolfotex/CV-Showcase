package com.example.cm1601_cw_partb;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleSetProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Objects;

public class SceneController {
    private Stage stage;
    private Scene scene;
    private Parent parent;
    @FXML
    private BorderPane mainWindow;
    @FXML
    private TextField driverNameField, driverAgeField, driverTeamField, driverCarField, driverPointsField, updateDriverField, randomRaceDate;
    @FXML
    private Label errorLabel, standingsLabel;
    @FXML
    private TableColumn<Driver, Integer> standingsAge;
    @FXML
    private TableColumn<Driver, String> standingsCar;
    @FXML
    private TableColumn<Driver, String> standingsName;
    @FXML
    private TableColumn<Driver, Integer> standingsPoints;
    @FXML
    private TableView<Driver> standingsTable;
    @FXML
    private TableColumn<Driver, String> standingsTeam;
    @FXML
    private TableView<Race> raceTableView;
    @FXML
    private TableColumn<Race, String> raceTableDate;
    @FXML
    private TableColumn<Race, String> raceTableLocation;

    private static ArrayList<Driver> drivers = new ArrayList<Driver>();
    private static ArrayList<Driver> randomPosDrivers = new ArrayList<Driver>();
    public static ArrayList<Race> races = new ArrayList<>();
    private static Driver updatingDriver;


    public void switchToMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Menu-View.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void switchToAddDriver(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AddDriver-View.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void switchToDeleteDriver(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("DeleteDriver-View.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void switchToUpdateDriver(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("UpdateDriver-View2.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void switchToStandings(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Standings-View.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void switchToRandomRace(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("RandomRace-View.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void switchToRaceTable(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("RaceTable-View.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }



    public void exit(ActionEvent event) throws IOException{
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("You're about to exit");
        alert.setContentText("Do you want to exit the program?");

        if (alert.showAndWait().get() == ButtonType.OK){
            stage = (Stage) mainWindow.getScene().getWindow();
            stage.close();
        }
    }

    public void addDriver(ActionEvent event) throws IOException {
        AddDriver addD = new AddDriver();
        addD.addDriver(driverNameField, driverAgeField, driverTeamField, driverCarField, driverPointsField, errorLabel, drivers);
    }

    public void deleteDriver(ActionEvent event){
        DeleteDriver deleteD = new DeleteDriver();
        deleteD.deleteDriver(driverNameField, drivers, errorLabel);
    }

    public void updateDriver(ActionEvent event) throws IOException {
        UpdateDriver updateD = new UpdateDriver();
        updateD.updateDriverP1(updateDriverField, drivers, updatingDriver, errorLabel, driverNameField, driverAgeField, driverTeamField, driverCarField, driverPointsField);
    }

    public void standings(ActionEvent event){
        Standings standings = new Standings();
        standings.standings(drivers);

        standingsName.setCellValueFactory(new PropertyValueFactory<>("name"));
        standingsAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        standingsTeam.setCellValueFactory(new PropertyValueFactory<>("team"));
        standingsCar.setCellValueFactory(new PropertyValueFactory<>("car"));
        standingsPoints.setCellValueFactory(new PropertyValueFactory<>("currentPoints"));

        for (Driver driver: drivers){
            standingsTable.getItems().add(driver);
        }
    }

    public void randomRace(ActionEvent event){
        RandomRace randomR = new RandomRace();
        randomPosDrivers = (ArrayList<Driver>) drivers.clone();
        randomR.randomRace(randomRaceDate, errorLabel, randomPosDrivers, standingsTable, standingsName, standingsAge,standingsTeam, standingsCar, standingsPoints);

    }

    public void raceTable(ActionEvent event){
        raceTable raceT = new raceTable();
        raceT.raceStat(races, raceTableView, raceTableDate, raceTableLocation);

        raceTableDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        raceTableLocation.setCellValueFactory(new PropertyValueFactory<>("location"));

        for (Race race: races){
            raceTableView.getItems().add(race);
        }
    }

    public void saveData(ActionEvent event){
        SaveData ssd = new SaveData();
        ssd.saveDataDriver(drivers, errorLabel);
        ssd.saveDataRaces(races, errorLabel);

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("");
        alert.setHeaderText("Data Saved");
        alert.setContentText("Data has been Saved");
        alert.show();
    }

    public void loadData(ActionEvent event){
        SaveData ssd = new SaveData();
        ssd.loadDataDriver(drivers, errorLabel);
        ssd.loadDataRaces(races, errorLabel);

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("");
        alert.setHeaderText("Data loaded");
        alert.setContentText("Data has been loaded");
        alert.show();
    }
}