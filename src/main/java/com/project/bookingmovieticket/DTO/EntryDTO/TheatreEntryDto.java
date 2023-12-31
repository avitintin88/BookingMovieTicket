package com.project.bookingmovieticket.DTO.EntryDTO;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TheatreEntryDto {
    String name;
    String address;
    String city;
}
