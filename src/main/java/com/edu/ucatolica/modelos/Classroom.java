package com.edu.ucatolica.modelos;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String location;

    private int capacity;

    @Getter
    @OneToMany(mappedBy = "classroom")
    private List<Group> groups;

    public void addGroup(Group group) {
        groups.add(group);
        group.setClassroom(this);
    }

}

