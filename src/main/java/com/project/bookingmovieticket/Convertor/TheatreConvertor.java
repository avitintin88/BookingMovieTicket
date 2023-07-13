package com.project.bookingmovieticket.Convertor;

import com.project.bookingmovieticket.DTO.EntryDTO.TheatreEntryDto;
import com.project.bookingmovieticket.DTO.ResponseDTO.TheatreResponseDto;
import com.project.bookingmovieticket.Models.TheatreEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TheatreConvertor {
    public static TheatreEntity convertDtoToEntity(TheatreEntryDto theatreEntryDto){
        return TheatreEntity.builder().name(theatreEntryDto.getName()).address(theatreEntryDto.getAddress()).city(theatreEntryDto.getCity()).build();
    }
    public static TheatreResponseDto convertEntitytoDto(TheatreEntity theatre){
        return TheatreResponseDto.builder().id(theatre.getId()).name(theatre.getName())
                .address(theatre.getAddress()).city(theatre.getCity())
                .type(theatre.getType()).build();
    }
}
