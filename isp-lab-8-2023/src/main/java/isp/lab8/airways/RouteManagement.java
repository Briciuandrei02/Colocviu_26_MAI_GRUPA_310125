package isp.lab8.airways;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RouteManagement {
    private static final String ROUTE_FOLDER_PATH = "./routes/";

    public static void main(String[] args) {
        RouteManagement routeManagement = new RouteManagement();
        routeManagement.createRoute("LRCL-LROP");
        routeManagement.addWaypoint("LRCL-LROP", new Waypoint(1, "LRCL", 46.7852, 23.6862, 415));
        routeManagement.addWaypoint("LRCL-LROP", new Waypoint(2, "TASOD", 47.0548, 23.9212, 10460));
        routeManagement.addWaypoint("LRCL-LROP", new Waypoint(3, "SOPAV", 46.9804, 24.7365, 10900));
        routeManagement.addWaypoint("LRCL-LROP", new Waypoint(4, "BIRGU", 45.9467, 26.0217, 10200));
        routeManagement.addWaypoint("LRCL-LROP", new Waypoint(5, "LROP", 44.5711, 26.0858, 106));
        routeManagement.saveRoute("LRCL-LROP");
        routeManagement.loadRoute("LRCL-LROP");
        routeManagement.deleteRoute("LRCL-LROP");
        routeManagement.listRoutes();
    }

    public void createRoute(String name) {
        File routeFolder = new File(ROUTE_FOLDER_PATH + name);
        if (!routeFolder.exists()) {
            routeFolder.mkdir();
            System.out.println("Route" + name + "created");
        } else {
            System.out.println("already exists!");
        }
    }

    public void deleteRoute(String name) {
        File routeFolder = new File(ROUTE_FOLDER_PATH + name);
        if (routeFolder.exists()) {
            File[] files = routeFolder.listFiles();
            if (files != null) {
                for (File file : files) {
                    file.delete();
                }
            }
            routeFolder.delete();
            System.out.println("Route " + name + " deleted.");
        } else {
            System.out.println("Does not exist!(DeleteRoute)");
        }
    }

    public void addWaypoint(String routeName, Waypoint waypoint) {
        Route route = loadRouteFromFile(routeName);
        if (route != null) {
            int index = route.getWaypoints().size() + 1;
            waypoint.setIndex(index);
            route.addWaypoint(waypoint);
            System.out.println("Waypoint " + waypoint.getName() + " added to route " + routeName + ".");
        } else {
            System.out.println("Does not exist!(addWaypoint)");
        }
    }

    public void saveRoute(String name) {
        Route route = loadRouteFromFile(name);
        if (route != null) {
            try {
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ROUTE_FOLDER_PATH + name + "/" + name + ".route"));
                oos.writeObject(route);
                oos.close();
                for (Waypoint waypoint : route.getWaypoints()) {
                    ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream(ROUTE_FOLDER_PATH + name + "/" + waypoint.getName() + ".waypoint"));
                    oos2.writeObject(waypoint);
                    oos2.close();
                }
                System.out.println("Route " + name + " saved.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Does not exist!(SaveRoute)");
        }
    }


    public void loadRoute(String name) {
        {
            Route route = null;
            try {
                route = loadRouteFromFile(name);
                System.out.println("Route " + name + " has total distance of " + route.getTotalDistance() + " kilometers.");
                System.out.println("Waypoints:");
                for (Waypoint waypoint : route.getWaypoints()) {
                    System.out.println("Waypoint " + waypoint.getIndex() + ": " + waypoint.getName() + " (" + waypoint.getLatitude() + ", " + waypoint.getLongitude() + ", " + waypoint.getAltitude() + ")");
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Failed to load route " + name + ". IOException occurred: " + e.getMessage());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println("Failed to load route " + name + ". ClassNotFoundException occurred: " + e.getMessage());
            }
        }
    }


        public void listRoutes () {
                File routesFolder = new File(ROUTE_FOLDER_PATH);
                File[] files = routesFolder.listFiles();
                if (files != null) {
                    List<String> routeNames = new ArrayList<>();
                    for (File file : files) {
                        if (file.isDirectory()) {
                            routeNames.add(file.getName());
                        }
                    }
                    if (routeNames.isEmpty()) {
                        System.out.println("No routes found.");
                    } else {
                        System.out.println("Available routes:");
                        for (String routeName : routeNames) {
                            System.out.println("- " + routeName);
                        }
                    }
                } else {
                    System.out.println("No routes found.");
                }
            }
        }


    private Route loadRouteFromFile(String name) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ROUTE_FOLDER_PATH + name + "/" + name + ".route"));
        Route route = (Route) ois.readObject();
        ois.close();

        File[] files = new File(ROUTE_FOLDER_PATH + name).listFiles();
        if (files != null) {
            List<Waypoint> waypoints = new ArrayList<>();
            for (File file : files) {
                if (file.getName().endsWith(".waypoint")) {
                    ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream(file));
                    Waypoint waypoint = (Waypoint) ois2.readObject();
                    ois2.close();
                    waypoints.add(waypoint);
                }
            }
            if (!waypoints.isEmpty()) {
                route.getWaypoints().clear();
                route.getWaypoints().addAll(waypoints);
            }
        }

        return route;
    }
}