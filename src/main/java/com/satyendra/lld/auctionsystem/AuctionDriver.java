package com.satyendra.lld.auctionsystem;

public class AuctionDriver {
    public static void main(String[] args) {

        UserService userService = new UserService();
        AuctionStrategy auctionStrategy = new UniqueHighestBidder();
        AuctionService auctionService = new AuctionService(userService, auctionStrategy);

        /*
        *  ADD_BUYER(“buyer1”)
● ADD_BUYER(“buyer2”)
● ADD_BUYER(“buyer3”)
● ADD_SELLER(“seller1”)
● CREATE_AUCTION(“A1”, “10”, “50”, “1”, “seller1”)
● CREATE_BID(“buyer1”, “A1”, “17”)
● CREATE_BID(“buyer2”, “A1”, “15”)
● UPDATE_BID(“buyer2”, “A1”, “19”)
● CREATE_BID(“buyer3”, “A1”, “19”)
● CLOSE_AUCTION(“A1”) // Should give Buyer1 as winner
*/
        userService.addBuyer(1, "buyer1");
        userService.addBuyer(2, "buyer2");
        userService.addBuyer(3, "buyer3");
        userService.addSeller(4, "seller1");
        auctionService.createAuction(1, "A1", 10.0, 50.0, 1.0, 4);
        auctionService.createOrUpdateBid(1, 17.0, 1);
        auctionService.createOrUpdateBid(1, 15.0, 2);
        auctionService.createOrUpdateBid(1, 19.0, 2);
        auctionService.createOrUpdateBid(1, 19.0, 3);
        System.out.println(auctionService.closeAuction(1));
        System.out.println(auctionService.closeAuction(1));

        /*
        * ADD_SELLER(“seller2”)
● CREATE_AUCTION(“A2”, “5”, “20”, “2”, “seller2”)
● CREATE_BID(“buyer3”, ”A2”, 25) //This should fail as highest bid limit is 20 for A2
● CREATE_BID(“buyer2, ”A2”, 5)
● WITHDRAW_BID(“buyer2”, “A2”)
● CLOSE_AUCTION(“A2”) // No winner
*/
        userService.addSeller(5, "seller2");
        auctionService.createAuction(2, "A2", 5.0, 20.0, 2.0, 5);
        auctionService.createOrUpdateBid(2, 25.0, 3);
        auctionService.createOrUpdateBid(2, 5.0, 2);
        auctionService.withdraw(2, 2);
        System.out.println(auctionService.closeAuction(2));
    }
}
