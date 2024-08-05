package com.edu.ucatolica.modelos;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String specialty;

    @Getter
    @OneToMany(mappedBy = "professor")
    private List<Subject> subjects;

    public void addSubject(Subject subject) {
        subjects.add(subject);
        subject.setProfessor(this);
    }

}
