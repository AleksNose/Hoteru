package com.aleksnose.hoteru.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ReservationDTO {
    private Integer Id;
    private LocalDate DateFrom;
    private LocalDate DateTo;
    private Integer IdUser;
    private Integer IdRoom;
}
