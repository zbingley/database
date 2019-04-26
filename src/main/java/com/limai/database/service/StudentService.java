package com.limai.database.service;

import com.limai.database.repository.entity.Student;

/**
 * @Author: zhangbin
 * @Date: 2018/11/29 15:24
 * @Desc:
 */
public interface StudentService {
    void saveStudent(Student student) throws Exception;

    void saveV2Student(Student student);
}
