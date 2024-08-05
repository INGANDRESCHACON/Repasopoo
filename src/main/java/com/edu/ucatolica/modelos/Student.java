package com.edu.ucatolica.modelos;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String phone;


    @Getter
    @ManyToMany(mappedBy = "students")
    private List<Group> groups;

    public void enrollInGroup(Group group) {
        groups.add(group);
        group.getStudents().add(this);
    }

    public void addSubject(Subject subject) {
        for (Group group : subject.getGroups()) {
            enrollInGroup(group);
        }
    }

    public void makePayment(double amount) {
        // Aquí va lógica de pago, como actualizar el balance del estudiante, registrar la transacción, etc.
        System.out.println("Payment of $" + amount + " made by student " + name);
    }


}
