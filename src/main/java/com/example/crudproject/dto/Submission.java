package com.example.crudproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Submission {
    private String id;
    private String name;
    private String date;
    private String column1;
    private int column2;
    private String column3;
}
