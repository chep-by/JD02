package by.itacademy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class Commend {

    @Column(name = "datetime_commend")
    private LocalDateTime dateTime;

    @Column(name = "commend_text")
    private String commend;
}
