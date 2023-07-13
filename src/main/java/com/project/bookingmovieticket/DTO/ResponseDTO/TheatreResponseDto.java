package com.project.bookingmovieticket.DTO.ResponseDTO;

import com.project.bookingmovieticket.ENUM.TheatreType;
import com.sun.istack.NotNull;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TheatreResponseDto {
    @NotNull
    int id;
    String name;
    String address;
    String city;
    TheatreType type;
}
