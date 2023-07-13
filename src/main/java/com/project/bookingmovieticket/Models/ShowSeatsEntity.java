package com.project.bookingmovieticket.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ShowSeats")
@Builder
@ToString
public class ShowSeatsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "rate",nullable = false)
    private int rate;
    @Column(name = "seatNo",nullable = false)
    private String seatNo;

    @Enumerated(EnumType.STRING)
    @Column(name = "seatType",nullable = false)
    private com.project.bookingmovieticket.ENUM.seatType seatType;

    @Column(name = "isBooked",nullable = false)
    private boolean booked;


    @Column(name = "bookedAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date bookedAt;

    @ManyToOne
    @JsonIgnore
    private TicketEntity ticket;

    @ManyToOne
    @JsonIgnore
    private ShowEntity show;
}
