package ch.fhnw.assignment1.cartelgroup;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;

    public class MainIceCream extends Application {
        @Override
        public void start(Stage primaryStage) throws Exception {
            Parent root = FXMLLoader.load(getClass().getResource("/view/icecream_ui.fxml"));
            primaryStage.setTitle("Ice Cream Cashier");
            primaryStage.setScene(new Scene(root, 500, 400));
            primaryStage.show();
        }

        public static void main(String[] args) {
            launch(args);
        }
    }

