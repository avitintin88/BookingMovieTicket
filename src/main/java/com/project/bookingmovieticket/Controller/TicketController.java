package com.project.bookingmovieticket.Controller;

import com.project.bookingmovieticket.DTO.BookTicketRequestDto;
import com.project.bookingmovieticket.DTO.ResponseDTO.TicketResponseDto;
import com.project.bookingmovieticket.Service.Implementation.TicketServiceImplement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheConfig;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("ticket")
@CacheConfig(cacheNames={"tickets"})
public class TicketController {
    @Autowired
    TicketServiceImplement ticketServiceImplement;

    @PostMapping("/add")
    public ResponseEntity<TicketResponseDto> addTicket(@Valid @RequestBody()BookTicketRequestDto bookTicketRequestDto){
        TicketResponseDto ticketResponseDto=ticketServiceImplement.bookTicket(bookTicketRequestDto);
        return new ResponseEntity<>(ticketResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    @Cacheable(value="ticketInfo")
    public ResponseEntity<TicketResponseDto> getTicketById(@PathVariable(value="id")int id){
        TicketResponseDto ticketResponseDto=ticketServiceImplement.getTicket(id);
        return new ResponseEntity<>(ticketResponseDto,HttpStatus.OK);
    }
}
