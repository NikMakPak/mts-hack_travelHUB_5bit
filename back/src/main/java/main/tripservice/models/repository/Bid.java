package main.tripservice.models.repository;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
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
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "bid_statuses")
    ArrayList<Status> statuses;

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

    @OneToOne
    @JoinColumn(name = "bid_order")
    Document order;

    @OneToMany
    @JoinColumn(name = "bid_tickets")
    Set<Document> tickets;

    @OneToMany
    @JoinColumn(name = "bid_hotels")
    Set<Document> hotel;

    @OneToOne
    @JoinColumn(name = "bid_report")
    Document report;

    @NonNull
    @OneToOne
    @JoinColumn(name = "bid_user")
    User user;

}
