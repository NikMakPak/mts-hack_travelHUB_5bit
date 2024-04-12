package main.tripservice.models.service;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class BidServiceModel {

    String reason;

    String departureCity;

    String arrivalCity;

    Timestamp departureDate;

    Timestamp arrivalDate;

}
