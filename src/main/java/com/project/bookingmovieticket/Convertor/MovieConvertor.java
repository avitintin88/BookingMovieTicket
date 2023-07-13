package com.project.bookingmovieticket.Convertor;

import com.project.bookingmovieticket.DTO.EntryDTO.MovieEntryDto;
import com.project.bookingmovieticket.DTO.ResponseDTO.MovieResponseDto;
import com.project.bookingmovieticket.Models.MovieEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MovieConvertor {
     public static MovieEntity convertDtoToEntity(MovieEntryDto movieEntryDto){
         return MovieEntity.builder().name(movieEntryDto.getName()).releaseDate(movieEntryDto.getReleaseDate()).build();
     }
     public static MovieResponseDto convertEntityToDto(MovieEntity movie){
         return MovieResponseDto.builder().id(movie.getId()).name(movie.getName()).releaseDate(movie.getReleaseDate()).build();
     }

}
