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
            try {
                getAircrafts(reader);
            } catch (LauncherException e) {
                System.out.println(e.getMessage());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void getAircrafts(BufferedReader reader) throws LauncherException {
        try {
            String line = reader.readLine();
            while (line != null) {
                try {
                    String[] args = line.split("\\s+");
                    if (args.length != 5) {
                        throw new LauncherException("Failed to create vehicle: Incorrect number of parameters to create aircraft [" + line + "]");
                    }
                    try {
                        Aircrafts.add(AircraftFactory.newAircraft(args[0], args[1], Integer.parseInt(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4])));
                    } catch (NumberFormatException e) {
                        System.out.println("Failed to parse integer from [" + line + "]");
                    }
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
