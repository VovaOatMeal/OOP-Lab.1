package sample.Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.DBQueries;

public class AddRowWindow {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField nameField;

    @FXML
    private TextField capitalField;

    @FXML
    private TextField regionField;

    @FXML
    private Button submitButton;

    @FXML
    private Button cancelButton;

    @FXML
    private TextField continentField;

    @FXML
    private TextField codeField;

    @FXML
    void cancelAction(ActionEvent actionEvent) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void submitAction(ActionEvent event) {
        if (nameField.getText().isEmpty()) {
            // дать по мозгам
            Alert dialog = new Alert(Alert.AlertType.ERROR);
            dialog.setTitle("Пустое поле названия");
            dialog.setHeaderText("Не задано название страны.");
            dialog.setContentText("Пожалуйста, введите название страны.");
            dialog.showAndWait();
            return;
        }
        DBQueries.insertQuery(nameField.getText(), capitalField.getText(),
                regionField.getText(), continentField.getText(), codeField.getText());
        Stage stage = (Stage) submitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {
    }
}
