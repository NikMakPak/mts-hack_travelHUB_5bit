package main.tripservice.models.repository;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "bids")
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @NonNull
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "bid_statuses")
    List<Status> statuses;

    @NonNull
    String reason;

    @NonNull
    String departureCity;

    @NonNull
    String arrivalCity;

    @NonNull
    Timestamp departureDate;

    @NonNull
    Timestamp arrivalDate;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false)
    Timestamp createdAt;

    BigDecimal prepayment;

    @OneToMany
    @JoinColumn(name = "bid_expenses")
    Set<Expense> expenses;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "bid_order")
    Document order;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "bid_tickets")
    Set<Document> tickets;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "bid_hotels")
    Set<Document> hotel;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "bid_report")
    Document report;

    @NonNull
    @OneToOne
    @JoinColumn(name = "bid_user")
    User user;

}
