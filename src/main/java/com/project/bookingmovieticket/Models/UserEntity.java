package com.project.bookingmovieticket.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="Users")
@ToString
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name",nullable = false)
    private String name;
    @Column(name="mobile",nullable = false)
    private String mobileNumber;



    @OneToMany(mappedBy = "user",cascade=CascadeType.ALL)    //bi directional mapping
    @JsonIgnore
    private List<TicketEntity> listOfTickets;
}
