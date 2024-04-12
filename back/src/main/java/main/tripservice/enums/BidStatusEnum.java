package main.tripservice.enums;

public enum BidStatusEnum {

    BID_CREATED("Bid created"),
    BID_FIRST_SQUAD_APPROVED("Bid was firstly approved by SQUAD"),
    BID_FIRST_SQUAD_REJECTED("Bid was firstly rejected by SQUAD"),
    ID_SECOND_MANAGER_APPROVED("Bid was secondly approved by MANAGER"),
    BID_FIRST_ACCOUNTING_APPROVED("Bid firstly was approved by ACCOUNTING"),
    BID_FIRST_ACCOUNTING_REJECTED("Bid firstly was rejected by ACCOUNTING"),
    BID_SECOND_SQUAD_APPROVED("Bid was secondly approved by SQUAD"),
    BID_SECOND_SQUAD_REJECTED("Bid was secondly rejected by SQUAD"),
    BID_SECOND_MANAGER_APPROVED("Bid was secondly approved by MANAGER"),
    BID_TRIP_ACTIVE("Trip active"),
    BID_TRIP_CLOSED("Trip ended"),
    BID_REPORT_CREATED("ACCOUNTING create report");

    private final String bidStatus;

    BidStatusEnum(String bidStatus){
        this.bidStatus = bidStatus;
    }
    public String getBidStatus(){
        return bidStatus;
    }

}
