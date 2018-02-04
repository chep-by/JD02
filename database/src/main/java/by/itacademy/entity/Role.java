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
@Table(name = "roles")
public class Role extends BaseEntity {

    @Column(name = "role_name", nullable = false, unique = true)
    private String role;

    @ManyToMany(mappedBy = "role_id")
    private Set<User> user_id;
}
