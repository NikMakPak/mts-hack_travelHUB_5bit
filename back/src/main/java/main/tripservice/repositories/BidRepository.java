package main.tripservice.repositories;

import main.tripservice.models.repository.Bid;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BidRepository extends CrudRepository<Bid, Long> {

    Optional<Bid> findById(long id);

}
