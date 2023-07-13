package com.project.bookingmovieticket.Service;

import com.project.bookingmovieticket.DTO.EntryDTO.MovieEntryDto;
import com.project.bookingmovieticket.DTO.ResponseDTO.MovieResponseDto;

public interface MovieService {

    MovieResponseDto addMovie(MovieEntryDto movieEntryDto);

    MovieResponseDto getMovie(int id);
}
