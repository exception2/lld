package com.satyendra.lld.vehiclerental;

import java.util.*;

public class VehicleService {

    private final Map<String, List<Vehicle>> branchToVehiclesMap;

    public VehicleService() {
        this.branchToVehiclesMap = new HashMap<>();
    }

    public void addVehicle(Vehicle newVehicle, Branch branch) {
        branchToVehiclesMap.putIfAbsent(branch.getName(), new ArrayList<>());
        List<Vehicle> vehicleList = branchToVehiclesMap.get(branch.getName());

        for(Vehicle vehicle : vehicleList) {
            if(vehicle.getName().equalsIgnoreCase(newVehicle.getName())) {
                vehicle.setQuantity(newVehicle.getQuantity() + vehicle.getQuantity());
                break;
            }
        }
        vehicleList.add(newVehicle);
    }

    public Map<String, List<Vehicle>> getBranchToVehiclesMap() {
        return branchToVehiclesMap;
    }


    public List<String> getAllAvailableVehiclesWithMarketNames(Date startDate, Date endDate) {
        List<String> results = new ArrayList<>();
        for(Map.Entry<String, List<Vehicle>> entry : this.branchToVehiclesMap.entrySet()) {
            results.add(entry.getKey() + ":");
            for(Vehicle vehicle : entry.getValue()) {
                int count = findAvailableVehicleCount(vehicle, startDate, endDate);
                if (count == 0) {
                    results.add("All " + vehicle.getName() + " are booked.");
                } else {
                    results.add(vehicle.getName() + " is available for Rs." + vehicle.getChargePerHour());
                }
            }
        }
        return results;
    }

    private int findAvailableVehicleCount(Vehicle vehicle, Date startDate, Date endDate) {
        int count = vehicle.getQuantity();
        for(Booking booking : vehicle.getBookingList()) {
            if(endDate.before(booking.getStartDateTime()) || startDate.after(booking.getEndDateTime())) {
                continue;
            } else {
                count--;
            }
        }
        return count;
    }
}
