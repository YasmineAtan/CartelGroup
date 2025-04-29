package ch.fhnw.assignment1.cartelgroup;

public class Scoop {
        private String flavor;
        private double grossPrice;

        public Scoop(String flavor, double grossPrice) {
            this.flavor = flavor;
            this.grossPrice = grossPrice;
        }

        public String getFlavor() {
            return flavor;
        }

        public double getGrossPrice() {
            return grossPrice;
        }

        @Override
        public String toString() {
            return flavor + " - CHF " + String.format("%.2f", grossPrice);
        }
    }
