package com.limai.database.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonSaveReq {
    private int id;
    private String name;
    private String gender;
    private String height;
    private int age;
    private String address;
}
