package com.project.bookingmovieticket.DTO;

import com.project.bookingmovieticket.ENUM.seatType;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookTicketRequestDto {
    int userId;
    int showId;
    Set<String> requestedSeats;
    seatType seatType;
    double amount;
}
