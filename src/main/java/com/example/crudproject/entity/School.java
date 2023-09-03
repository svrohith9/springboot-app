package com.example.crudproject.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "school")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "school_id")
    private Long schoolId;

    @Column(name = "school_name")
    private String schoolName;

    @Column(name = "established_year")
    private int establishedYear;

    @Column(name = "principal_name")
    private String principalName;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "school")
    @JsonManagedReference  // This annotation handles the forward part of the reference.
    private List<Student> students;
}
