package com.satyendra.lld.auctionsystem;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Bid {

    private User buyer;
    private double bidAmount;
}
