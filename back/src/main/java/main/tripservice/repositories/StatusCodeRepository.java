package main.tripservice.repositories;

import main.tripservice.models.repository.StatusCode;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatusCodeRepository extends CrudRepository<StatusCode,Long> {

    Optional<StatusCode> findByCode(int i);

}
