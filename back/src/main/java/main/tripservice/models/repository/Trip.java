/*
package main.tripservice.models.repository;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "trips")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String status;

    @OneToOne
    @JoinColumn(name = "trip_bid")
    Bid bid;

    @OneToOne
    @JoinColumn(name = "trip_order")
    Document order;

    @OneToMany
    @JoinColumn(name = "trip_ticket")
    Set<Document> tickets;

    @OneToOne
    @JoinColumn(name = "trip_hotel")
    Document hotel;

    @OneToOne
    @JoinColumn(name = "trip_report")
    Document report;


    BigDecimal prePayment;


    @OneToMany
    @JoinColumn(name = "trip_expenses")
    Set<Expense> expenses;


}
*/
