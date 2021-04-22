package sample;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class DBQueries {

    public static void selectQuery() throws SQLException {

        final String QUERY = "SELECT * FROM countries";
        ResultSet resultSet = Main.statement.executeQuery(QUERY);

        try {

            while (resultSet.next()) {
                int id = resultSet.getInt("CountryID");
                String Name = resultSet.getString("Name");
                String Capital = resultSet.getString("Capital");
                String Region = resultSet.getString("Region");
                String Continent = resultSet.getString("Continent");
                String Code = resultSet.getString("Code");

                Main.countryArrayList.add(new Country(id, Name, Capital, Region, Continent, Code));
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        resultSet.close();
        resultSet = null;
    }

    public static void updateQuery(int id, String Name, String Capital, String Region, String Continent, String Code) {

        try {
            final String QUERY = "UPDATE countries SET " +
                    "Name = '" + Name +
                    "', Capital = '" + Capital +
                    "', Region = '" + Region +
                    "', Continent = '" + Continent +
                    "', Code = '" + Code +
                    "' WHERE CountryID = " + id;
            Main.statement.executeUpdate(QUERY);
        } catch (SQLException e) {
            System.out.println(e.toString() +
                    "\nHappened in updateQuery()");
        }
    }

    public static ResultSet loadQuery(int id) throws SQLException {
        try {
            final String QUERY = "SELECT * FROM countries WHERE CountryID = " + id;
            ResultSet resultSet = Main.statement.executeQuery(QUERY);

            return resultSet;
        } catch (SQLException e) {
            System.out.println(e.toString() +
                    "\nHappened in loadQuery()");
            return null;
        }
    }

    public static void insertQuery(String Name, String Capital, String Region, String Continent, String Code) {
        try {
            final String QUERY = "INSERT INTO countries " +
                    "(`Name`,\n" +
                    "`Capital`,\n" +
                    "`Region`,\n" +
                    "`Continent`,\n" +
                    "`Code`)\n" +
                    "VALUES ('" + Name + "', '" + Capital + "', '" + Region + "', '" + Continent + "', '" + Code + "');";
            Main.statement.executeUpdate(QUERY);
        } catch (SQLException e) {
            System.out.println(e.toString() +
                    "\nHappened in insertQuery()");
        }
    }

    public static void deleteQuery(int id) {
        try {
            final String QUERY = "DELETE FROM countries WHERE CountryID = " + id + ";";
            Main.statement.executeUpdate(QUERY);
        } catch (SQLException e) {
            System.out.println(e.toString() +
                    "\nHappened in deleteQuery()");
        }

    }
}
