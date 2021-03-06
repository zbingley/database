package com.limai.database.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Author: zhangbin
 * @Date: 2018/11/29 15:20
 * @Desc:
 */
@Entity
@Table(name = "teacher")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public Teacher(String name) {
        this.name = name;
    }
}
