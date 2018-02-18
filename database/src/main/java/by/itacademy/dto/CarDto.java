package by.itacademy.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CarDto {

    private static final int OLDEST_CAR_IN_PARK = 1980;

    private String manufacture;
    private String model;
    private String vehicleCategoryName;
    private int yearMin = OLDEST_CAR_IN_PARK;
    private int yearMax = LocalDate.now().getYear();
    private int perPage;
    private int page;
    private int standardPriceMin = 0;
    private int standardPriceMax = Integer.MAX_VALUE;
    private String transmission;
    private String gearbox;

}
