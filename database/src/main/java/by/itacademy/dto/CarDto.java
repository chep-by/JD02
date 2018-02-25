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

    private static final int CURRENT_YEAR = LocalDate.now().getYear();
    private static final int FIRST_PAGE = 1;
    private static final int FORTY_YEARS_AGO = CURRENT_YEAR - 40;

    private String manufacture;
    private String model;
    private String vehicleCategoryName;
    private int yearMin = FORTY_YEARS_AGO;
    private int yearMax = CURRENT_YEAR;
    private int perPage;
    private int page = FIRST_PAGE;
    private int standardPriceMin;
    private int standardPriceMax = Integer.MAX_VALUE;
    private String transmission;
    private String gearbox;

}
