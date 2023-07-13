package com.project.bookingmovieticket.Controller;

import com.project.bookingmovieticket.DTO.EntryDTO.ShowEntryDto;
import com.project.bookingmovieticket.DTO.ResponseDTO.ShowResponseDto;
import com.project.bookingmovieticket.Service.Implementation.ShowServiceImplement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("show")
public class ShowController {
    @Autowired
    ShowServiceImplement showServiceImplement;

    @PostMapping("/add")
    public ResponseEntity addShow(@Valid @RequestBody() ShowEntryDto showEntryDto){
        ShowResponseDto showResponseDto=showServiceImplement.addShow(showEntryDto);
        log.info("Thw showResponseDto is ",showResponseDto);
        return new ResponseEntity("Added Show successfully", HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ShowResponseDto> getShow(@PathVariable(value="id")int id){
        ShowResponseDto showDto=showServiceImplement.getShow(id);
        return new ResponseEntity<>(showDto,HttpStatus.OK);
    }
}
