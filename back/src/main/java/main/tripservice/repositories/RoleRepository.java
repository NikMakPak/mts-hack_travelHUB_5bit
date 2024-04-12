package main.tripservice.repositories;

import main.tripservice.models.repository.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {


    Optional<Role> getRoleById(int id);

}
