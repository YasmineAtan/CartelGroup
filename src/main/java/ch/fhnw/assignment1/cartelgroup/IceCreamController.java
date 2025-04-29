package ch.fhnw.assignment1.cartelgroup;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.TreeItem;

import java.util.ArrayList;
import java.util.List;

public class IceCreamController {

    @FXML private ComboBox<Scoop> flavorCombo;
    @FXML private TreeView<String> coneTree;
    @FXML private Button addScoopButton;
    @FXML private Button newConeButton;
    @FXML private Button finishOrderButton;
    @FXML private Label lblOrderInfo;

    private List<Cone> cones = new ArrayList<>();
    private Cone currentCone;
    private TreeItem<String> rootItem;
    private int orderCount = 1;

    @FXML
    public void initialize() {
        flavorCombo.getItems().addAll(
                new Scoop("Vanilla", 2.50),
                new Scoop("Chocolate", 2.80),
                new Scoop("Strawberry", 2.70),
                new Scoop("Mint", 2.60)
        );

        startNewOrder();

        newConeButton.setOnAction(e -> createNewCone());
        addScoopButton.setOnAction(e -> addScoopToCone());
        finishOrderButton.setOnAction(e -> printReceipt());
    }

    private void startNewOrder() {
        cones.clear();
        currentCone = null;

        String orderLabel = "Order #" + orderCount;
        lblOrderInfo.setText(orderLabel);

        rootItem = new TreeItem<>(orderLabel);
        coneTree.setRoot(rootItem);
        coneTree.setShowRoot(true);

        createNewCone();
    }

    private void createNewCone() {
        currentCone = new Cone();
        cones.add(currentCone);

        TreeItem<String> coneItem = new TreeItem<>("Cone ordered: " + currentCone.getOrderDate());
        rootItem.getChildren().add(coneItem);
        coneTree.getSelectionModel().select(coneItem);
    }

    private void addScoopToCone() {
        TreeItem<String> selectedConeItem = coneTree.getSelectionModel().getSelectedItem();
        Scoop selectedScoop = flavorCombo.getValue();

        if (selectedScoop == null) {
            showAlert("Selection Error", "Please select a flavor before adding it.");
            return;
        }

        if (currentCone != null && selectedConeItem != null) {
            if (currentCone.addScoop(selectedScoop)) {
                selectedConeItem.getChildren().add(new TreeItem<>(selectedScoop.toString()));
            } else {
                showAlert("Max scoops reached", "Each cone can have a maximum of 3 scoops.");
            }
        }
    }

    private void printReceipt() {
        System.out.println("==== RECEIPT ====");
        double total = 0;

        for (Cone cone : cones) {
            System.out.println("Order date: " + cone.getOrderDate());
            for (Scoop scoop : cone.getScoops()) {
                System.out.println(" - " + scoop.getFlavor() + ": CHF " + scoop.getGrossPrice());
                total += scoop.getGrossPrice();
            }
        }

        double vat = total * 0.025;
        System.out.printf("Included VAT: CHF %.2f%n", vat);
        System.out.printf("TOTAL: CHF %.2f%n", total);
        System.out.println("=================");
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}

