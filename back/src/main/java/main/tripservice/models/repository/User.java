package main.tripservice.models.repository;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @NonNull
    byte[] name;

    @NonNull
    byte[] surname;

    @NonNull
    @Column(unique = true)
    String email;

    @NonNull
    @JsonIgnore
    String password;

    @NonNull
    int grade;

    @NonNull
    byte[] passport;

    @OneToMany
    @JoinColumn(name = "user_bids")
    Set<Bid> bids;

    @OneToOne
    @JoinColumn(name = "user_squad")
    Squad squad;

    @OneToOne
    @JoinColumn(name = "user_role")
    Role role;

}
