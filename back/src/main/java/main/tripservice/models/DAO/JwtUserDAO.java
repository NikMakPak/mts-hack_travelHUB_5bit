package main.tripservice.models.DAO;

import lombok.*;
import lombok.experimental.FieldDefaults;
import main.tripservice.models.repository.Bid;
import main.tripservice.models.repository.Role;
import main.tripservice.models.repository.Squad;

import java.util.Set;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JwtUserDAO {

    @NonNull
    String token;

    @NonNull
    long id;

    @NonNull
    String name;

    @NonNull
    String surname;

    @NonNull
    String email;

    @NonNull
    int grade;

    @NonNull
    String passport;

    @NonNull
    Set<Bid> bids;

    @NonNull
    Squad squad;

    @NonNull
    Role role;

}
