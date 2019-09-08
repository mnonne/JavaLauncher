package Simulation;

import Interface.Flyable;

import java.io.*;
import java.util.ArrayList;

public class Simulator
{
    private static int NumSimulations = 0;
    private static ArrayList<Flyable> Aircrafts = new ArrayList<Flyable>();

    public static void main(String[] args) {
        if (!checkNumArgs(args))
            System.exit(-1);

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(args[0]));
            getNumSimulations(reader.readLine());
            getAircrafts(reader);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void getAircrafts(BufferedReader reader) {
        try {
            String line = reader.readLine();
            while (line != null) {
                try {
                    Aircrafts.add(AircraftFactory.newAircraft("Baloon", "B1", 1, 1, 1));
                    System.out.println(line);
                } catch (LauncherException e) {
                    System.out.println(e.getMessage());
                }
                line = reader.readLine();
            }
        }
       catch (IOException e) {
            System.out.println("Unable to read aircrafts");
       }
    }

    private static boolean checkNumArgs(String[] args)
    {
        if (args.length != 1) {
            System.out.println("Program takes one and only one argument - scenario file!");
            return false;
        }
        return true;
    }

    private static void getNumSimulations(String str) {
        try {
            NumSimulations = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println("Failed to read number of simulations");//TODO: throw here own exception
        }
    }
}
