package isp.lab8.airways;

import java.util.ArrayList;
import java.util.List;

public class Route {
    private String name;
    private List<Waypoint> waypoints;

    public Route(String name) {
        this.name = name;
        this.waypoints = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Waypoint> getWaypoints() {
        return waypoints;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }

    public void addWaypoint(Waypoint waypoint) {
        waypoints.add(waypoint);
    }

    public void removeWaypoint(Waypoint waypoint) {
        waypoints.remove(waypoint);
    }

    public double getTotalDistance() {
        double totalDistance = 0;
        if (waypoints.size() > 1) {
            for (int i = 0; i < waypoints.size() - 1; i++) {
                Waypoint from = waypoints.get(i);
                Waypoint to = waypoints.get(i + 1);
                totalDistance = totalDistance + WaypointDistanceCalculator.calculateDistance(from.getLatitude(), from.getLongitude(), to.getLatitude(), to.getLongitude());
            }
        }
        return totalDistance;
    }
}
