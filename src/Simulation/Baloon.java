package Simulation;

import Interface.Flyable;

public class Baloon extends Aircraft implements Flyable {
    Baloon(String name, Coordinates coordinate) {
        super(name, coordinate);
        System.out.println("Baloon is created:");
        System.out.println("Name: " + this.name);
        System.out.println("ID: " + this.id);
        System.out.println("Coordinates: " + this.coordinates.getLongitude() + " " + this.coordinates.getLongitude() + " " + this.coordinates.getHeight());
    }
    public void updateConditions() {

    }
}
