package com.project.bookingmovieticket.DTO.EntryDTO;

import lombok.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntryDto {
    @NotNull
    String name;
    @Pattern(regexp="^[0-9]{10}",message="length must be 10")
    String mobileNumber;
}
