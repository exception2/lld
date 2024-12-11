package com.satyendra.lld.vehiclerental;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class BookingService implements BookingStrategy {

    private VehicleService vehicleService;

    public BookingService(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    public String rentVehicle(String vehicleName, Date startDateTime, Date endDateTime) {
        Map<String, List<Vehicle>> vehicleBranchMap = vehicleService.getBranchToVehiclesMap();
        double price = Integer.MAX_VALUE;
        Vehicle foundVehicle = null;
        String branchName = null;
        for(Map.Entry<String, List<Vehicle>> entry : vehicleBranchMap.entrySet()) {

            for(Vehicle vehicle : entry.getValue()) {
                if(vehicle.getName().equalsIgnoreCase(vehicleName) && vehicle.getQuantity() > 0) {
                    Vehicle eligibleVehicle = checkVehicleAvailableInTimeInterval(startDateTime, endDateTime, vehicle);
                    if(eligibleVehicle != null && eligibleVehicle.getChargePerHour() < price) {
                        foundVehicle = eligibleVehicle;
                        price = foundVehicle.getChargePerHour();
                        branchName = entry.getKey();
                    }
                }
            }
        }
        if(foundVehicle != null) {
            foundVehicle.getBookingList().add(new Booking(startDateTime, endDateTime));
            return branchName;
        } else {
            return null;
        }
    }

    private Vehicle checkVehicleAvailableInTimeInterval(Date startDateTime, Date endDateTime, Vehicle vehicle) {
        if (vehicle.getBookingList().isEmpty()) {
            return vehicle;
        }
        int count  = 0;
        for(Booking booking : vehicle.getBookingList()) {
            if(!(startDateTime.after(booking.getEndDateTime()) || endDateTime.before(booking.getStartDateTime()))) {
                count++;
            }
        }
        if(count < vehicle.getQuantity()) {
            return vehicle;
        }
        return null;
    }


}
