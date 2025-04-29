package ch.fhnw.assignment1.cartelgroup;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;

public class IceCreamCalculator {
    private final Map<String, Double> selectedFlavors = new LinkedHashMap<>();
    public void addFlavor(String flavor, double price) {
        selectedFlavors.put(flavor, price);
    }
    public double CalculateSubtotal() {
        return selectedFlavors.values().stream().mapToDouble(Double::doubleValue).sum();
    }
    public String GenerateReceipt(int orderNumber) {
        StringBuilder IceReceipt = new StringBuilder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss z yyyy");
        IceReceipt.append("Order #").append(orderNumber).append(" ")
                .append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss")))
                .append(" CEST 2025\n");

        IceReceipt.append("Cone #1\n");
        selectedFlavors.forEach((flavor, price) ->
                IceReceipt.append(String.format("  %-15s CHF %.2f\n", flavor, price)));
        IceReceipt.append(String.format("Total:%21sCHF %.2f", " ", CalculateSubtotal()));

        return IceReceipt.toString();
    }

    public void clear() {
        selectedFlavors.clear();
}
}
