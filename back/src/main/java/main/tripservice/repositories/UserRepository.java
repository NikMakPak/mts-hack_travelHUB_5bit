package main.tripservice.repositories;

import main.tripservice.models.repository.Squad;
import main.tripservice.models.repository.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByEmail(String email);


    Optional<Set<User>> findAllBySquad(Squad squad);




}
