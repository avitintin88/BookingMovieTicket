package com.project.bookingmovieticket.Convertor;

import com.project.bookingmovieticket.DTO.ResponseDTO.TicketResponseDto;
import com.project.bookingmovieticket.DTO.TicketDto;
import com.project.bookingmovieticket.Models.TicketEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TicketConvertor {
    public static TicketEntity convertDtoToEntity(TicketDto ticketDto){
        return TicketEntity.builder().allotedSeats(ticketDto.getAllotedSeats()).amount(ticketDto.getAmount()).build();
    }
    public static TicketResponseDto convertEntityToDto(TicketEntity ticket){
        return TicketResponseDto.builder().id(ticket.getId()).allotedSeats(ticket.getAllotedSeats()).amount(ticket.getAmount()).build();
    }

}
