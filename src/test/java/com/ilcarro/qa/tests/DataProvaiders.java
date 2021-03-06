package com.ilcarro.qa.tests;

import com.ilcarro.qa.model.Car;
import com.ilcarro.qa.model.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProvaiders {
    @DataProvider
    public Iterator<Object[]> validUser(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"fNamea", "lName", "l11name@gmail.com", "1Z2345678"});
        list.add(new Object[]{"faNames", "laName", "l221name@gmail.com", "1X2345678"});
        list.add(new Object[]{"fzNamed", "lzName", "l331name@gmail.com", "1C2345678"});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]>  validUserFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(
                new File("src/test/resources/newUser.csv")));

        String line = reader.readLine();
        while (line !=null){
            String[] split = line.split(",");
            list.add(new Object[]{new User().setfName(split[0]).setlName(split[1]).setEmail(split[2]).setPassword(split[3])});
            line=reader.readLine();
        }


        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]>  validCarFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/addCar.csv")));

        String line = reader.readLine();
        while (line !=null){
            String[] split = line.split(",");
            list.add(new Object[]{new Car()
                    .setCountry(split[0])
                    .setAddress(split[1])
                    .setDistance(split[2])
                    .setSerialNumber(split[3])
                    .setBrand(split[4])
                    .setModel(split[5])
                    .setYear(split[6])
                    .setEngine(split[7])
                    .setFuelConsumption(split[8])
                    .setFuel(split[9])
                    .setTransmission(split[10])
                    .setWd(split[11])
                    .setHorsepower(split[12])
                    .setTorque(split[13])
                    .setDoors(split[14])
                    .setSeats(split[15])
                    .setClasss(split[16])
                    .setAbout(split[17])
                    .setFeature(split[18])
                    .setPrice(split[19])});
            line=reader.readLine();
        }


        return list.iterator();
    }
}
