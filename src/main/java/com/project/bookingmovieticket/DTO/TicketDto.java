package com.project.bookingmovieticket.DTO;

import com.project.bookingmovieticket.DTO.ResponseDTO.ShowResponseDto;
import com.project.bookingmovieticket.DTO.ResponseDTO.UserResponseDto;
import com.sun.istack.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TicketDto {
    int id;
    String allotedSeats;
    double amount;

    @NotNull
    UserResponseDto userDto;

    ShowResponseDto showDto;
}

