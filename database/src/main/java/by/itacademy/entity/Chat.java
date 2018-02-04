package by.itacademy.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "chats")
public class Chat extends BaseEntity {

    @OneToMany(mappedBy = "chat")
    private Set<ChatLine> chatLine;
}
