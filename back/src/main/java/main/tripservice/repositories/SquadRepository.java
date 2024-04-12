package main.tripservice.repositories;

import main.tripservice.models.repository.Squad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SquadRepository extends CrudRepository<Squad, Long> {
}
