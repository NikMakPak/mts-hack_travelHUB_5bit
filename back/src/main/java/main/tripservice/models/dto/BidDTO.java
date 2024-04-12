package main.tripservice.models.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BidDTO {

    long id;

    String reason;

    String departureCity;

    String arrivalCity;

    Timestamp departureDate;

    Timestamp arrivalDate;

}
