package main.tripservice.models.DAO;

import lombok.*;
import lombok.experimental.FieldDefaults;
import main.tripservice.models.repository.Bid;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BidDAO {

    Set<Bid> bids;

}
