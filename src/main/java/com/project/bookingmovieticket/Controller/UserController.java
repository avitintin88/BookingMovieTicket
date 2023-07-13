package com.project.bookingmovieticket.Controller;

import com.project.bookingmovieticket.Service.Implementation.UserServiceImplement;
import com.project.bookingmovieticket.DTO.EntryDTO.UserEntryDto;
import com.project.bookingmovieticket.DTO.ResponseDTO.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserServiceImplement userServiceImplement;

    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody UserEntryDto userDto){
        userServiceImplement.addUser(userDto);
        return new ResponseEntity("Added user successfully", HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable(value="id")int id){
        UserResponseDto userDto=userServiceImplement.getUser(id);
        return new ResponseEntity<>(userDto,HttpStatus.OK);
    }


}
