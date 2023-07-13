package com.project.bookingmovieticket.Controller;


import com.project.bookingmovieticket.DTO.EntryDTO.TheatreEntryDto;
import com.project.bookingmovieticket.DTO.ResponseDTO.TheatreResponseDto;
import com.project.bookingmovieticket.Service.Implementation.TheatreServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("theatre")
public class TheatreController {
    @Autowired
    TheatreServiceImplement theatreServiceImplement;

    @PostMapping("/add")
    public ResponseEntity addTheatre(@Valid @RequestBody() TheatreEntryDto theatreEntryDto){
        theatreServiceImplement.addTheatre(theatreEntryDto);
        return new ResponseEntity("Added theatre successfully", HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<TheatreResponseDto> getTheatre(@PathVariable(value="id")int id){
        TheatreResponseDto theatreDto=theatreServiceImplement.getTheatre(id);
        return new ResponseEntity<>(theatreDto,HttpStatus.OK);
    }
}
