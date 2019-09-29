package com.limai.database.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "person",catalog = "",schema = "mydb")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String gender;
    private String height;
    private int age;
    private String address;
    private Timestamp gmtCreate;
    private Timestamp gmtModified;
    private String country;

}
