package com.satyendra.lld.auctionsystem;

import java.util.*;

public class UniqueHighestBidder implements AuctionStrategy {
    @Override
    public User findWinner(Auction auction) {
        List<Bid> bids = new ArrayList<>();
        for(Map.Entry<Integer, Bid> entry : auction.getBidMap().entrySet()) {
            bids.add(entry.getValue());
        }
        if(bids.isEmpty()) {
            System.out.println("No bids found!");
            return null;
        } else if (bids.size() == 1) {
            return bids.get(0).getBuyer();
        }
        bids.sort(new Comparator<Bid>() {
            @Override
            public int compare(Bid b1, Bid b2) {
                if (b1.getBidAmount() > b2.getBidAmount()) {
                    return -1;
                } else if (b1.getBidAmount() < b2.getBidAmount()) {
                    return 1;
                }
                return 0;
            }
        });

        Map<Double, Integer> map = new HashMap<>();
        for(Bid bid : bids) {
            map.putIfAbsent(bid.getBidAmount(), 0);
            map.computeIfPresent(bid.getBidAmount(), (k, v) -> v + 1);
        }

        for(Bid bid : bids) {
            if(map.get(bid.getBidAmount()) == 1) {
                return bid.getBuyer();
            }
        }
        System.out.println("No winner!");
        return null;
    }
}
