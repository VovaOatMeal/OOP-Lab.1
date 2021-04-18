package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        primaryStage.setTitle("Countries");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static ArrayList<Country> countryArrayList = new ArrayList<>();
    public static Connection connection = null;
    public static Statement statement;
    public static final String URL = "jdbc:mysql://localhost:3306/oop_lab1_countries";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "1234";

    public static void main(String[] args) {
        try {
            launch(args);

            if (!connection.isClosed()) {
                connection.close();
                System.out.println("The server has been successfully closed.");
            }
            connection = null;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
}
