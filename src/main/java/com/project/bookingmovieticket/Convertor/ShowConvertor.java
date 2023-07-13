package com.project.bookingmovieticket.Convertor;

import com.project.bookingmovieticket.DTO.EntryDTO.ShowEntryDto;
import com.project.bookingmovieticket.DTO.ResponseDTO.ShowResponseDto;
import com.project.bookingmovieticket.Models.ShowEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ShowConvertor {
    public static ShowEntity convertDtoToEntity(ShowEntryDto showEntryDto){
        return ShowEntity.builder().showDate(showEntryDto.getShowDate()).build();
    }
    public static ShowResponseDto convertEntityToDto(ShowEntity show, ShowEntryDto showEntryDto){
        return ShowResponseDto.builder().id(show.getId()).showDate(show.getShowDate())
                .movieResponseDto(MovieConvertor.convertEntityToDto(show.getMovie()))
                .theatreResponseDto(TheatreConvertor.convertEntitytoDto(show.getTheatre()))
                .build();

    }
}

