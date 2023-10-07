package service;

import connection.DBConnection;
import enums.Queries;
import exception.CarNotFoundException;
import model.Car;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static connection.DBConnection.closeConnection;
import static connection.DBConnection.getConnection;
import static enums.Queries.*;

public class CarService {


    private static PreparedStatement preparedStatement;

    public static void createCarTable() {
        var query = CREATE_CAR_TABLE.getQuery();
        var connection = getConnection();
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
            System.out.println("Car table created successfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
            System.out.println("Database connection closed");
        }

    }

    public static void createCar(Car car) {
        var query = INSERT_CAR.getQuery();
        var connection = getConnection();
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, car.getId());
            preparedStatement.setString(2, car.getName());
            preparedStatement.setInt(3, car.getSpeed());
            preparedStatement.setInt(4, car.getReleaseDate());
            preparedStatement.setDouble(5, car.getEngine());
            preparedStatement.setString(6, car.getColor());
            preparedStatement.execute();
            System.out.println("Created car successfully : " + car);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
            System.out.println("Database connection closed");
        }

    }

    public Car getCarById(Long id) {
        var query = FIND_BY_ID.getQuery();
        var connection = getConnection();
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return fillCar(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
            System.out.println("Database connection closed");


        }
        throw new CarNotFoundException("Car not found with id " + id);

    }

    public void updateCarName(Long id, String name) {
        var query = Queries.UPDATE_CAR_NAME.getQuery();
        var connection = getConnection();

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setLong(2, id);
            var result = preparedStatement.executeUpdate();
            System.out.println("Car name updated successfully. Row count = " + result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
            System.out.println("Database connection closed");
        }


    }

    public void deleteCar(Long id) {
        var query = DELETE_CAR.getQuery();
        var connection = getConnection();
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }

    }

    public List<Car> getCars() {
        String query = Queries.GET_ALL_CARS.getQuery();
        List<Car> carList = new ArrayList<>();
        var connection = getConnection();
        try {
            preparedStatement = connection.prepareStatement(query);
            var resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                var car = fillCar(resultSet);
                carList.add(car);

            }
            return carList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closePreparedStatement(preparedStatement);
            closeConnection(connection);
        }

    }

    public static void closePreparedStatement(PreparedStatement preparedStatement) {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public Car fillCar(ResultSet resultSet) throws SQLException {
        var carId = resultSet.getLong(1);
        var carName = resultSet.getString(2);
        var carSpeed = resultSet.getInt(3);
        var carReleaseDate = resultSet.getInt(4);
        var carEngine = resultSet.getDouble(5);
        var carColor = resultSet.getString(6);
        return new Car(carId, carName, carSpeed, carReleaseDate, carEngine, carColor);
    }

}
