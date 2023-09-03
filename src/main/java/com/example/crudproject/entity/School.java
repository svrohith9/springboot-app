package com.example.crudproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;

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
    // This denotes the One-to-Many relationship with Student. The "mappedBy" attribute indicates that the "school" field in Student is the owning side.
    private List<Student> students;
}
