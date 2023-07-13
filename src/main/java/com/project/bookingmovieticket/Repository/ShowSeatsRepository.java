package com.project.bookingmovieticket.Repository;

import com.project.bookingmovieticket.Models.ShowSeatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowSeatsRepository extends JpaRepository<ShowSeatsEntity,Integer> {
}
