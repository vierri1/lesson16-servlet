package repository.manufacturer;


import ConnectionManager.ConnectionManager;
import ConnectionManager.ConnectionManagerJdbcImpl;
import pojo.Manufacturer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManufacturerDaoImpl implements ManufacturerDao {
    private ConnectionManager connectionManager = ConnectionManagerJdbcImpl.getInstance();

    @Override
    public boolean add(Manufacturer manufacture) {

        try (
             Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mobile", "postgres", "root");
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO manufacturer VALUES (DEFAULT, ?, ?)")) {
            preparedStatement.setString(1, manufacture.getName());
            preparedStatement.setString(2, manufacture.getCountry());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Manufacturer getById(Integer id) {
        Manufacturer manufacturer;
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (
             Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mobile", "postgres", "root");
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM manufacturer WHERE id=?")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                manufacturer = new Manufacturer(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("country"));
                return manufacturer;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Manufacturer mobile) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (
             Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mobile", "postgres", "root");
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE manufacturer SET name=?, country=? WHERE id=?")) {
            preparedStatement.setString(1, mobile.getName());
            preparedStatement.setString(2, mobile.getCountry());
            preparedStatement.setInt(3, mobile.getId());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteById(Integer id) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (
             Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mobile", "postgres", "root");
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM manufacturer WHERE id=?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Manufacturer> getAll() {
        List<Manufacturer> manufacturers = null;
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (
             Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mobile", "postgres", "root");
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM manufacturer")) {
            manufacturers = new ArrayList<>();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String country = resultSet.getString("country");
                manufacturers.add(new Manufacturer(id, name, country));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return manufacturers;
    }
}
