package main.tripservice.repositories;

import main.tripservice.models.repository.Expense;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Long> {
}
