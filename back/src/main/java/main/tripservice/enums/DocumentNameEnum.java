package main.tripservice.enums;

public enum DocumentNameEnum {

    DOCUMENT_ORDER("BID_ORDER"),
    DOCUMENT_BILL("DOCUMENT_BILL"),
    DOCUMENT_TICKET("DOCUMENT_TICKET"),
    DOCUMENT_REPORT("DOCUMENT_REPORT");

    private final String documentName;

    DocumentNameEnum(String documentName){
        this.documentName = documentName;
    }
    public String getDocumentName(){
        return documentName;
    }

}
