package com.limai.database.service.impl;

import com.limai.database.repository.StudentRepository;
import com.limai.database.repository.TeacherRepository;
import com.limai.database.repository.entity.Student;
import com.limai.database.repository.entity.Teacher;
import com.limai.database.service.StudentService;
import com.limai.database.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: zhangbin
 * @Date: 2018/11/29 16:21
 * @Desc:
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Override
    public void saveTeacher(Teacher teacher) throws Exception {

    }
    //设置了rollbackFor = Exception.class可以不需要手动抛出异常，一旦方法安排出异常事务就会回滚
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveV2Teacher(Student student, String id,String name) {
        Student save = studentRepository.save(student);
        int a=10/0;
        int i = teacherRepository.updateTeacherById(id, name);
        System.out.println("iiii:"+i);
      /*  if(null==save || i==0){
            throw new RuntimeException("事务出错");
        }*/

    }
}
