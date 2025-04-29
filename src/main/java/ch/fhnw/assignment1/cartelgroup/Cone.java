package ch.fhnw.assignment1.cartelgroup;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Cone {
    private LocalDateTime orderDate;
    private List<Scoop> scoops;

    public Cone() {
        this.orderDate = LocalDateTime.now();
        this.scoops = new ArrayList<>();
    }

    public boolean addScoop(Scoop scoop) {
        if (scoops.size() < 3) {
            scoops.add(scoop);
            return true;
        }
        return false;
    }

    public List<Scoop> getScoops() {
        return scoops;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public double getTotalGross() {
        return scoops.stream().mapToDouble(Scoop::getGrossPrice).sum();
    }
}
