package ch.fhnw.assignment1.cartelgroup;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class IceCreamController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}