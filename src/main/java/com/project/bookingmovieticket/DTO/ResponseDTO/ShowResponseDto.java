package com.project.bookingmovieticket.DTO.ResponseDTO;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShowResponseDto {
    int id;
    LocalDateTime showDate;


    MovieResponseDto movieResponseDto;
    TheatreResponseDto theatreResponseDto;
}
