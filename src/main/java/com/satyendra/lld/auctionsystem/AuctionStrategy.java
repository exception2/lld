package com.satyendra.lld.auctionsystem;

public interface AuctionStrategy {
    User findWinner(Auction auction);
}
