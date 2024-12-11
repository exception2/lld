package com.satyendra.lld.auctionsystem;

import java.util.HashMap;
import java.util.Map;

public class AuctionService {

    private Map<Integer, Auction> auctionMap;
    private final UserService userService;
    private final AuctionStrategy auctionStrategy;
    public AuctionService(UserService userService, AuctionStrategy auctionStrategy) {
        this.auctionStrategy = auctionStrategy;
        this.userService = userService;
        this.auctionMap = new HashMap<>();
    }

    void createAuction(int id, String name, double lowBidLimit, double highBidLimit, double participantCost, int sellerId) {
        Auction auction = auctionMap.get(id);
        if (auction != null) {
            System.out.println("Already auction present with id : " + id);
            return;
        }
        if(lowBidLimit > highBidLimit) {
            System.out.println("Bid range is not correct");
            return;
        }

        User seller = userService.getUser(sellerId);
        if(seller.getUserType() != UserType.SELLER) {
            System.out.println("Seller is not registered user!");
            return;
        }
        auctionMap.put(id, new Auction(id, name, lowBidLimit, highBidLimit, participantCost, seller, Status.RUNNING, new HashMap<>()));
    }


    void createOrUpdateBid(int auctionId, double bidAmount, int buyerId) {
        User buyer = userService.getUser(buyerId);
        if(buyer.getUserType() != UserType.BUYER) {
            System.out.println("Buyer is not registered user!");
            return;
        }
        Auction auction = auctionMap.get(auctionId);
        if(auction == null) {
            System.out.println("auction not found!");
            return;
        } else if (bidAmount < auction.getLowBidLimit() || bidAmount > auction.getHighBidLimit()) {
            System.out.println("auction is not in range!");
            return;
        } else if(auction.getStatus() == Status.CLOSED) {
            System.out.println("auction is closed!");
            return;
        }

        Bid bid = auction.getBidMap().get(buyerId);
        if(bid == null) {
            auction.getBidMap().put(buyerId, new Bid(buyer, bidAmount));
        } else {
            bid.setBidAmount(bidAmount);
        }
    }

    public User closeAuction(int auctionId) {
        Auction auction = auctionMap.get(auctionId);
        if(auction == null) {
            System.out.println("auction not found!");
            return null;
        }
        if(Status.CLOSED == auction.getStatus()) {
            System.out.println("auction closed!");
            return null;
        }
        auction.setStatus(Status.CLOSED);
        return auctionStrategy.findWinner(auction);
    }

    public void withdraw(int auctionId, int buyerId) {
        Auction auction = auctionMap.get(auctionId);
        if(auction == null) {
            System.out.println("auction not found!");
        }
        if(Status.CLOSED == auction.getStatus()) {
            System.out.println("auction closed!");
        }
        auctionMap.get(auctionId).getBidMap().remove(buyerId);
    }
}
