package by.itacademy.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReservationDto {

    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate dateTake;

    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate dateReturn;

    private Long vehicleId;

    private String userName;

    private String commend;
}
