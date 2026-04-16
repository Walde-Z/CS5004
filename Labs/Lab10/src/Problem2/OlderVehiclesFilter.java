package Problem2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OlderVehiclesFilter {
    private List<Vehicle> vehicles = new ArrayList<>();

    public OlderVehiclesFilter(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public OlderVehiclesFilter(Vehicle vehicle1, Vehicle
            vehicle2, Vehicle vehicle3) {
        this.vehicles.add(vehicle1);
        this.vehicles.add(vehicle2);
        this.vehicles.add(vehicle2);
    }

    /**
     * Filters vehicles manufactured before 1999 and returns
     * a list of strings containing their make, model, and year.
     *
     * @return a List of Strings, each representing a vehicle's
     *         make, model, and year, for vehicles manufactured before 1999.
     */
    public List<String> filterOlderVehilces() {
        return vehicles.stream()
                .filter(v -> v.getYear() < 1999)
                .map(v -> v.getMake() + " " + v.getModel() + " " + v.getYear())
                .collect(Collectors.toList());
    }
}