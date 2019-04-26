package com.limai.database.service;

import com.limai.database.repository.entity.Student;
import com.limai.database.repository.entity.Teacher;

/**
 * @Author: zhangbin
 * @Date: 2018/11/29 15:24
 * @Desc:
 */
public interface TeacherService {
    void saveTeacher(Teacher teacher) throws Exception;

    void saveV2Teacher(Student student, String id,String name);
}
