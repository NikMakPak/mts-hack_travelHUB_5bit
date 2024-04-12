package main.tripservice.repositories;

import main.tripservice.models.repository.Squad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SquadRepository extends CrudRepository<Squad, Long> {

    Optional<Squad> findSquadById(int id);

}
