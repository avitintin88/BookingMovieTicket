package com.project.bookingmovieticket.Convertor;

import com.project.bookingmovieticket.DTO.EntryDTO.UserEntryDto;
import com.project.bookingmovieticket.DTO.ResponseDTO.UserResponseDto;
import com.project.bookingmovieticket.Models.UserEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserConvertor {
    public static UserEntity convertDtoToEntity(UserEntryDto userEntryDto){
        return UserEntity.builder().name(userEntryDto.getName()).mobileNumber(userEntryDto.getMobileNumber()).build();
    }
    public static UserResponseDto convertEntityToDto(UserEntity userEntity){
        return UserResponseDto.builder().id(userEntity.getId()).name(userEntity.getName()).mobileNumber(userEntity.getMobileNumber()).build();
    }
}
