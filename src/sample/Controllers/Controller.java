package sample.Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Country;
import sample.DBQueries;
import sample.Main;

import static sample.Main.*;
import static sample.Main.countryArrayList;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Country> tableID;

    @FXML
    private TableColumn<Country, Integer> idCol;

    @FXML
    private TableColumn<Country, String> nameCol;

    @FXML
    private TableColumn<Country, String> capitalCol;

    @FXML
    private TableColumn<Country, String> regionCol;

    @FXML
    private TableColumn<Country, String> continentCol;

    @FXML
    private TableColumn<Country, String> codeCol;

    @FXML
    private Button showButton;

    @FXML
    private Button addRowButton;

    @FXML
    private Button deleteRowButton;

    @FXML
    private Button editRowButton;

    @FXML
    void addWindow(ActionEvent event) {

    }

    @FXML
    void deleteWindow(ActionEvent event) {

    }

    @FXML
    public void editWindow(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/sample/Views/updateRowWindow.fxml"));
            Stage stage = new Stage();
            Stage primaryStage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow(); // accessing primaryStage from Main
            stage.initOwner(primaryStage); // setting which window will be locked
            stage.initModality(Modality.WINDOW_MODAL); // making new stage modal
            stage.setTitle("Edit row");
            stage.setScene(new Scene(root));
            stage.showAndWait();

            showData();

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        try {
            connection = DriverManager.getConnection(Main.URL, USERNAME, PASSWORD);

            if (!connection.isClosed()) {
                System.out.println("Running the server...");
            } else {
                System.out.println("Cannot run the server: connection is closed.");
                return;
            }

            if (connection != null) {
                statement = connection.createStatement();
            } else {
                System.out.println("connection is null.");
                return;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        idCol.setCellValueFactory(new PropertyValueFactory<>("CountryID"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
        capitalCol.setCellValueFactory(new PropertyValueFactory<>("Capital"));
        regionCol.setCellValueFactory(new PropertyValueFactory<>("Region"));
        continentCol.setCellValueFactory(new PropertyValueFactory<>("Continent"));
        codeCol.setCellValueFactory(new PropertyValueFactory<>("Code"));

    }

    public void showData() throws SQLException {
        if (!countryArrayList.isEmpty()) countryArrayList.clear();
        DBQueries.selectQuery();

        ObservableList<Country> countryObservableList = null;
        countryObservableList = FXCollections.observableArrayList(
                countryArrayList);

        tableID.setItems(countryObservableList);
    }

}
