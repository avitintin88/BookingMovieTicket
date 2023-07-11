package com.example.project.bookmyshowbackend.DTO.EntryDTO;

import com.example.project.bookmyshowbackend.DTO.ResponseDTO.MovieResponseDto;
import com.example.project.bookmyshowbackend.DTO.ResponseDTO.TheatreResponseDto;
import com.sun.istack.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShowEntryDto {
    @NotNull
    LocalDateTime showDate;

    @NotNull
    int movieId;
    @NotNull
    int theatreId;
}
