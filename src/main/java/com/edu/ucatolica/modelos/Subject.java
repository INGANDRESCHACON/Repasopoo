package com.edu.ucatolica.modelos;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int credits;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @Getter
    @OneToMany(mappedBy = "subject")
    private List<Group> groups;

    public void addGroup(Group group) {
        groups.add(group);
        group.setSubject(this);
    }

}

