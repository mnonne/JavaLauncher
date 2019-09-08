package Simulation;

import Interface.Flyable;

public class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws LauncherException {
        if (type.equalsIgnoreCase("baloon")) {
            return new Baloon(name, new Coordinates(longitude, latitude, height));
        }
        else {
            throw new LauncherException("Unknown vehicle type: [" + type + "]");
        }
    }
}
