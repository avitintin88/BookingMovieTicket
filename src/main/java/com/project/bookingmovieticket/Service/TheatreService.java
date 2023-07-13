package com.project.bookingmovieticket.Service;

import com.project.bookingmovieticket.DTO.EntryDTO.TheatreEntryDto;
import com.project.bookingmovieticket.DTO.ResponseDTO.TheatreResponseDto;

public interface TheatreService {
    TheatreResponseDto addTheatre(TheatreEntryDto theatreEntryDto);
    TheatreResponseDto getTheatre(int id);
}
