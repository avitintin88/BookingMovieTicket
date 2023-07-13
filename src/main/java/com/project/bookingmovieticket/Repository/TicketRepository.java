package com.project.bookingmovieticket.Repository;

import com.project.bookingmovieticket.Models.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<TicketEntity,Integer> {
}
