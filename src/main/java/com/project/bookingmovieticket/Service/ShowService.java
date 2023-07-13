package com.project.bookingmovieticket.Service;

import com.project.bookingmovieticket.DTO.EntryDTO.ShowEntryDto;
import com.project.bookingmovieticket.DTO.ResponseDTO.ShowResponseDto;

public interface ShowService {
    ShowResponseDto addShow(ShowEntryDto showEntryDto);
    ShowResponseDto getShow(int id);
}
