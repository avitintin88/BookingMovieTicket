package com.project.bookingmovieticket.DTO.EntryDTO;

import com.sun.istack.NotNull;
import lombok.*;

import java.time.LocalDateTime;

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
