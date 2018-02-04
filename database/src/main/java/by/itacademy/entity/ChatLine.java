package by.itacademy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "chat_lines")
public class ChatLine extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "chat_id", nullable = false)
    private Chat chat;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @AttributeOverrides(value = {
            @AttributeOverride(name = "dateTime", column = @Column(name = "date_time")),
            @AttributeOverride(name = "commend", column = @Column(name = "line_text"))
    })
    private Commend commend;
}
