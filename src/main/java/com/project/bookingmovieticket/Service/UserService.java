package com.project.bookingmovieticket.Service;

import com.project.bookingmovieticket.DTO.EntryDTO.UserEntryDto;
import com.project.bookingmovieticket.DTO.ResponseDTO.UserResponseDto;


public interface UserService {
    UserResponseDto addUser(UserEntryDto userEntryDto);
    UserResponseDto getUser(int id);

}
