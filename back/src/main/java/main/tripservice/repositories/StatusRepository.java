package main.tripservice.repositories;

import main.tripservice.models.repository.Status;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends CrudRepository<Status, Long> {
}
