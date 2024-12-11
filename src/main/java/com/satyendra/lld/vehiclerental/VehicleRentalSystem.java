package com.satyendra.lld.vehiclerental;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class VehicleRentalSystem {
    public static void main(String[] args) throws ParseException {

        VehicleService vehicleService = new VehicleService();
        BranchService branchService = new BranchService(vehicleService);
        BookingStrategy bookingStrategy = new BookingService(vehicleService);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        List<Vehicle> list1 = new ArrayList<>();
        list1.add(new Vehicle( "suv",1, 12, VehicleType.CAR, new ArrayList<>()));
        list1.add(new Vehicle( "sedan",3, 10, VehicleType.CAR, new ArrayList<>()));
        list1.add(new Vehicle( "bikes",3, 20, VehicleType.BIKE, new ArrayList<>()));

        List<Vehicle> list2 = new ArrayList<>();
        list2.add(new Vehicle( "sedan",3, 11, VehicleType.CAR, new ArrayList<>()));
        list2.add(new Vehicle( "bikes",3, 30, VehicleType.BIKE, new ArrayList<>()));
        list2.add(new Vehicle( "hatchback",4, 8, VehicleType.CAR, new ArrayList<>()));

        List<Vehicle> list3 = new ArrayList<>();
        list3.add(new Vehicle( "suv",1, 11, VehicleType.CAR, new ArrayList<>()));
        list3.add(new Vehicle( "bikes",10, 3, VehicleType.BIKE, new ArrayList<>()));
        list3.add(new Vehicle( "sedan",3, 10, VehicleType.CAR, new ArrayList<>()));

        branchService.addBranch(new Branch("koramangala"), list1);
        branchService.addBranch(new Branch("jayanagar"), list2);
        branchService.addBranch(new Branch("malleshwaram"), list3);

        vehicleService.addVehicle(new Vehicle("sedan", 1, 0.0, VehicleType.CAR, new ArrayList<>()), branchService.getBranchByName("koramangala"));
        System.out.println(bookingStrategy.rentVehicle("suv", simpleDateFormat.parse("2024-09-05 10:00"), simpleDateFormat.parse("2024-09-05 12:00")));
        System.out.println(bookingStrategy.rentVehicle("suv", simpleDateFormat.parse("2024-09-05 10:00"), simpleDateFormat.parse("2024-09-05 12:00")));
        System.out.println(bookingStrategy.rentVehicle("suv", simpleDateFormat.parse("2024-09-05 10:00"), simpleDateFormat.parse("2024-09-05 12:00")));

        printAll(vehicleService.getAllAvailableVehiclesWithMarketNames(simpleDateFormat.parse("2024-09-05 10:00"), simpleDateFormat.parse("2024-09-05 12:00")));
    }

    private static void printAll(List<String> allAvailableVehiclesWithMarketNames) {
        for(String str : allAvailableVehiclesWithMarketNames) {
            System.out.println(str);
        }
    }
}
