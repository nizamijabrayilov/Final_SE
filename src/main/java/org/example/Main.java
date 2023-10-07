package org.example;

import connection.DBConnection;
import model.Car;
import service.CarService;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Main{
    public static void main(String args[]) {
        var carService = new CarService();
       // DBConnection.getConnection();
       // CarService.createCarTable();
      /* carService.createCar(new Car(
                10L,
                "Mercedes-Benz e63 AMG",
                300,
                2017,
                5.5,
                "Black"));
*/
   // System.out.println(carService.getCarById(10L));

    }
}



