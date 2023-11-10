package com.example.cm1601_cw_partb;

import java.util.ArrayList;

public class Standings {
    public void standings(ArrayList<Driver> drivers){
        int length = drivers.size();
        Driver temp;

        for(int i = 0; i < length; i++){
            for (int j =1; j < (length - i); j++){
                if (drivers.get(j - 1).getCurrentPoints() < drivers.get(j).getCurrentPoints()){
                    temp = drivers.get(j - 1);
                    drivers.set((j - 1), drivers.get(j));
                    drivers.set(j, temp);
                }
            }
        }
    }
}
