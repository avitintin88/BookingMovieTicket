package com.project.bookingmovieticket.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="TheatreSeats")
@Builder
@ToString
public class TheatreSeatsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="seatNumber",nullable = false)
    private String seatNumber;

    @Column(name="rate",nullable = false)
    private int rate;

    @Enumerated(EnumType.STRING)
    @Column(name = "seatType",nullable = false)
    private com.project.bookingmovieticket.ENUM.seatType seatType;

    @ManyToOne
    @JsonIgnore
    @JoinColumn
    private TheatreEntity theatre;

}
