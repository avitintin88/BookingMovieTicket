package com.project.bookingmovieticket.Service.Implementation;

import com.project.bookingmovieticket.Convertor.UserConvertor;
import com.project.bookingmovieticket.DTO.EntryDTO.UserEntryDto;
import com.project.bookingmovieticket.DTO.ResponseDTO.UserResponseDto;
import com.project.bookingmovieticket.Models.UserEntity;
import com.project.bookingmovieticket.Repository.UserRepository;
import com.project.bookingmovieticket.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplement implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserResponseDto addUser(UserEntryDto userEntryDto) {
        //create a funtion that converts userDto to user
        UserEntity userEntity= UserConvertor.convertDtoToEntity(userEntryDto);
        userRepository.save(userEntity);
        UserResponseDto userResponseDto=UserConvertor.convertEntityToDto(userEntity);
        return userResponseDto;
    }

    @Override
    public UserResponseDto getUser(int id) {
        UserEntity userEntity=userRepository.findById(id).get();
        UserResponseDto userDto=UserConvertor.convertEntityToDto(userEntity);
        return userDto;
    }
}
