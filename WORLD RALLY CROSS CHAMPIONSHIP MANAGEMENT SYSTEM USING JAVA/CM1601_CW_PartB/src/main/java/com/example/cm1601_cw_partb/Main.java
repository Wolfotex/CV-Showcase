package com.example.cm1601_cw_partb;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import java.io.*;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Menu-View.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setResizable(false);
        stage.setTitle("World Rally Cross Championship");
        stage.setScene(scene);
        stage.show();

        // display and get confirmation when exiting using the 'x' icon in the window
        stage.setOnCloseRequest(event -> {
            event.consume();
            exit(stage);
        });
    }

    public static void main(String[] args) {
        launch();
    }

    public void exit(Stage stage){
        // confirm when exiting the program
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("You're about to exit");
        alert.setContentText("Do you want to exit the program?");

        if (alert.showAndWait().get() == ButtonType.OK){
            stage.close();
        }
    }
}
