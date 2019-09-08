package Simulation;

import java.util.ArrayList;
import Interface.Flyable;

public class Tower {
    private ArrayList<Flyable> observers;

    public void register(Flyable flyable) {
        observers.add(flyable);
//        flyable.registerWeatherTower(this);
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
    }
}
