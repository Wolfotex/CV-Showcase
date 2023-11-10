package com.example.cm1601_cw_partb;


import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class raceTable {
    public void raceStat(ArrayList<Race> races, TableView<Race> raceTableView, TableColumn<Race, String> racerTableDate, TableColumn<Race, String> racerTableLocation){
        for (int i = 0; i < races.size() - 1; i++) {
            for (int j = 0; j < races.size() - i - 1; j++) {
                if (races.get(j).getDate().compareTo(races.get(j+1).getDate()) > 0) {
                    Race temp = races.get(j);
                    races.set(j, races.get(j+1));
                    races.set(j+1, temp);
                }
            }
        }
    }
}
