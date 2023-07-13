package com.project.bookingmovieticket.DTO.ResponseDTO;


import com.project.bookingmovieticket.DTO.TicketDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDto {
    int id;
    String name;
    String mobileNumber;

    List<TicketDto> tickets;
}
