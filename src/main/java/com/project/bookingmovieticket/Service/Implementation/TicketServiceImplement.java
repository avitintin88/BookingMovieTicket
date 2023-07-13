package com.project.bookingmovieticket.Service.Implementation;

import com.project.bookingmovieticket.Convertor.TicketConvertor;
import com.project.bookingmovieticket.DTO.BookTicketRequestDto;
import com.project.bookingmovieticket.DTO.ResponseDTO.TicketResponseDto;
import com.project.bookingmovieticket.Models.ShowEntity;
import com.project.bookingmovieticket.Models.ShowSeatsEntity;
import com.project.bookingmovieticket.Models.TicketEntity;
import com.project.bookingmovieticket.Models.UserEntity;
import com.project.bookingmovieticket.Repository.ShowRepository;
import com.project.bookingmovieticket.Repository.TicketRepository;
import com.project.bookingmovieticket.Repository.UserRepository;
import com.project.bookingmovieticket.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class TicketServiceImplement implements TicketService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ShowRepository showRepository;
    @Autowired
    TicketRepository ticketRepository;

    @Override
    public TicketResponseDto getTicket(int id) {
        TicketEntity ticket=ticketRepository.findById(id).get();
        TicketResponseDto ticketDto= TicketConvertor.convertEntityToDto(ticket);
        return ticketDto;
    }

    @Override
    @Transactional
    public TicketResponseDto bookTicket(BookTicketRequestDto bookTicketRequestDto) {
        UserEntity user=userRepository.findById(bookTicketRequestDto.getUserId()).get();
        ShowEntity show=showRepository.findById(bookTicketRequestDto.getShowId()).get();
        Set<String> requestedSeats=bookTicketRequestDto.getRequestedSeats();

        List<ShowSeatsEntity> showSeatsList=show.getSeats();


        List<ShowSeatsEntity> availableSeats=showSeatsList.stream()
                .filter(seat -> seat.getSeatType().equals(bookTicketRequestDto.getSeatType()) && !seat.isBooked() &&
                        requestedSeats.contains(seat.getSeatNo())).collect(Collectors.toList());

       /* if(availableSeats.size() != requestedSeats.size()){
            throw new Error("All Seats not available");
        }*/

        //Step 2
        TicketEntity ticket= TicketEntity.builder().user(user).show(show).seats(availableSeats).build();

        //Step 3
        double amount=bookTicketRequestDto.getAmount();
        for(ShowSeatsEntity seat:availableSeats){
            seat.setBooked(true);
            seat.setBookedAt(new Date());
            seat.setTicket(ticket);
            seat.setShow(show);
            amount+=seat.getRate();
        }
        ticket.setAmount(amount);
        ticket.setAllotedSeats(bookTicketRequestDto.getRequestedSeats().toString());
        ticket.setBookedAt(new Date());

        user.getListOfTickets().add(ticket);
        show.getTicekts().add(ticket);

        ticket=ticketRepository.save(ticket);
        return TicketConvertor.convertEntityToDto(ticket);
    }

}
