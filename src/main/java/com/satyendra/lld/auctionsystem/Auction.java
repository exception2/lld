package com.satyendra.lld.auctionsystem;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class Auction {

    private int id;
    private String name;
    private double lowBidLimit;
    private double highBidLimit;
    private double participantCost;
    private User seller;
    private Status status;
    private Map<Integer, Bid> bidMap;
}
