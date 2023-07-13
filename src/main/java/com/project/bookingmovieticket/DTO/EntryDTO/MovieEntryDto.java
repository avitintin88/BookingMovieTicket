package com.project.bookingmovieticket.DTO.EntryDTO;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieEntryDto {
    String name;
    LocalDate releaseDate;
}
