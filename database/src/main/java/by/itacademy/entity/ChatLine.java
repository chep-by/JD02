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
    @JoinColumn(name = "chat_id")
    private Chat chat;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @AttributeOverrides(value = {
            @AttributeOverride(name = "dateTime", column = @Column(name = "datetime")),
            @AttributeOverride(name = "commend", column = @Column(name = "line_text"))
    })
    private Commend commend;
}
