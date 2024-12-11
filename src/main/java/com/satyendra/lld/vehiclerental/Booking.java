package com.satyendra.lld.vehiclerental;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Booking {

    private Date startDateTime;
    private Date endDateTime;
}
