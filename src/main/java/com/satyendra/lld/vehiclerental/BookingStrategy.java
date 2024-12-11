package com.satyendra.lld.vehiclerental;

import java.util.Date;

public interface BookingStrategy {
    String rentVehicle(String vehicleName, Date startDateTime, Date endDateTime);
}
