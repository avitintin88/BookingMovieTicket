package com.project.bookingmovieticket.Controller;

import com.project.bookingmovieticket.DTO.EntryDTO.MovieEntryDto;
import com.project.bookingmovieticket.DTO.ResponseDTO.MovieResponseDto;
import com.project.bookingmovieticket.Service.Implementation.MovieServiceImplement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;



@RestController
@RequestMapping("movie")
@Slf4j
public class MovieController {
    @Autowired
    MovieServiceImplement movieServiceImplement;

    @PostMapping("/add")
    public ResponseEntity addMovie(@Valid @RequestBody() MovieEntryDto movieEntryDto){
        MovieResponseDto movieResponseDto=movieServiceImplement.addMovie(movieEntryDto);
        log.debug("The movieResponseDto is ",movieResponseDto);
        return new ResponseEntity("Added movie successfully", HttpStatus.CREATED);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<MovieResponseDto> getUser(@PathVariable(value="id")int id){
        MovieResponseDto movieDto=movieServiceImplement.getMovie(id);
        return new ResponseEntity<>(movieDto,HttpStatus.OK);
    }
}
