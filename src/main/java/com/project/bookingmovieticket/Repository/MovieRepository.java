package com.project.bookingmovieticket.Repository;

import com.project.bookingmovieticket.Models.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity,Integer> {
    boolean existsByName(String name);
}
