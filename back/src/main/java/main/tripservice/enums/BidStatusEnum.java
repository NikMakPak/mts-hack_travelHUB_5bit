package main.tripservice.enums;

public enum BidStatusEnum {

    BID_CREATED("Bid created"),
    BID_SQUAD_APPROVED("Bid was approved by squad"),
    BID_ACCOUNTING_APPROVED("Bid was approved by accounting"),
    BID_SQUAD_REJECTED("Bid was rejected by squad"),
    BID_ACCOUNTING_REJECTED("Bid was rejected by accounting"),
    BID_TRIP_ACTIVE("Active"),
    BID_TRIP_CLOSED("Closed");

    private final String bidStatus;

    BidStatusEnum(String bidStatus){
        this.bidStatus = bidStatus;
    }
    public String getBidStatus(){
        return bidStatus;
    }

}
