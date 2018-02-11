package by.itacademy.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDto {
    private String manufacture;
    private String model;
    private int yearMin;
    private int yearMax;
    private int perPage;
    private int page;

    public CarDto(String manufacture, String model, int yearMin, int yearMax, int perPage, int page) {
        this.manufacture = manufacture;
        this.model = model;
        this.yearMin = yearMin;
        this.yearMax = yearMax;
        this.perPage = perPage;
        this.page = page;
    }
}
