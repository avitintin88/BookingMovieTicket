package com.project.bookingmovieticket.Repository;

import com.project.bookingmovieticket.Models.TheatreSeatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreSeatsRepository extends JpaRepository<TheatreSeatsEntity,Integer> {
}
