package com.project.bookingmovieticket.Service;

import com.project.bookingmovieticket.DTO.BookTicketRequestDto;
import com.project.bookingmovieticket.DTO.ResponseDTO.TicketResponseDto;

public interface TicketService {
    TicketResponseDto bookTicket(BookTicketRequestDto bookTicketRequestDto);
    TicketResponseDto getTicket(int id);
}
