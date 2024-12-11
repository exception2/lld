package com.satyendra.lld.vehiclerental;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Vehicle {

    private String name;
    private int quantity;
    private double chargePerHour;
    private VehicleType vehicleType;
    private List<Booking> bookingList;
}
