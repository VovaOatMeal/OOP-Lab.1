package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.DBQueries;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DeleteRowWindow {

    @FXML
    public Button cancelButton;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField idField;

    @FXML
    private Button submitButton;

    @FXML
    void initialize() {
    }

    public void submitAction(ActionEvent event) {
        if (idField.getText().isEmpty()) {
            // дать по мозгам
            Alert dialog = new Alert(Alert.AlertType.ERROR);
            dialog.setTitle("Пустое поле ID");
            dialog.setHeaderText("Не указано ID страны.");
            dialog.setContentText("Пожалуйста, введите ID страны, которую вы хотите удалить.");
            dialog.showAndWait();
            return;
        }
        DBQueries.deleteQuery(Integer.parseInt(idField.getText()));
        Stage stage = (Stage) submitButton.getScene().getWindow();
        stage.close();
    }

    public void cancelAction(ActionEvent actionEvent) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}
