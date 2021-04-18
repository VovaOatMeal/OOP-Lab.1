package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class UpdateRowWindow {

    @FXML
    public Button loadButton;

    @FXML
    public Button cancelButton;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField nameField;

    @FXML
    private TextField capitalField;

    @FXML
    private TextField idField;

    @FXML
    private TextField regionField;

    @FXML
    private TextField continentField;

    @FXML
    private TextField codeField;

    @FXML
    private Button submitButton;

    @FXML
    void initialize() {

    }

    public void loadAction(ActionEvent actionEvent) {

        int id;
        try {
            id = Integer.parseInt(idField.getText());
            if (id <= 0) {
                Alert dialog = new Alert(AlertType.ERROR);
                dialog.setTitle("Неверный ID");
                dialog.setHeaderText("Введенное значение меньше либо равно нуля.");
                dialog.setContentText("Пожалуйста, вводите только целые числа, которые больше 0.");
                dialog.showAndWait();

                idField.clear();
                return;
            }
        } catch (NumberFormatException formatException) {
            Alert dialog = new Alert(AlertType.ERROR);
            dialog.setTitle("Неверный ID");
            dialog.setHeaderText("Вы ввели нецелочисленное значение.");
            dialog.setContentText("Пожалуйста, вводите только целые числа.");
            dialog.showAndWait();

            idField.clear();
            return;
        }

        nameField.setDisable(false);
        capitalField.setDisable(false);
        regionField.setDisable(false);
        continentField.setDisable(false);
        codeField.setDisable(false);
        submitButton.setDisable(false);
        idField.setDisable(true);

        ResultSet resultSet = null;
        try {
            resultSet = DBQueries.loadQuery(id);
        } catch (SQLException exception) {
            System.out.println(exception.toString() +
                    "\nHappened in loadAction() when initializing resultSet");
            return;
        }

        if (resultSet != null) {
            try {
                resultSet.next();
                String Name = resultSet.getString("Name");
                String Capital = resultSet.getString("Capital");
                String Region = resultSet.getString("Region");
                String Continent = resultSet.getString("Continent");
                String Code = resultSet.getString("Code");

                nameField.setText(Name);
                capitalField.setText(Capital);
                regionField.setText(Region);
                continentField.setText(Continent);
                codeField.setText(Code);
            } catch (SQLException exception) {
                System.out.println(exception.toString() +
                        "\nHappened in loadAction() when getting values from resultSet");
                return;
            }
        } else {
            System.out.println("Error: resultSet is null.");
            return;
        }
    }

    public void submitAction(ActionEvent event) {
        DBQueries.updateQuery(Integer.parseInt(idField.getText()), nameField.getText(), capitalField.getText(),
                regionField.getText(), continentField.getText(), codeField.getText());
        Stage stage = (Stage) submitButton.getScene().getWindow();
        stage.close();
    }

    public void cancelAction(ActionEvent actionEvent) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}
