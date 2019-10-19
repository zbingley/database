package com.limai.database.service.impl;

import com.limai.database.repository.StudentRepository;
import com.limai.database.repository.entity.Student;
import com.limai.database.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;

/**
 * @Author: zhangbin
 * @Date: 2018/11/29 15:25
 * @Desc:
 */
@Slf4j
@Service
public class StudentServiceImpl  implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveStudent(Student student) throws Exception {
        studentRepository.save(student);
//        throw new SQLException("抛出一个异常");
    }

    @Override
    public boolean saveStudentV2(Student student) {
        Student save = studentRepository.save(student);
        return  save!=null;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveV2Student(Student student) {
        try {
            studentRepository.save(student);
//            throw new SQLException("抛出一个异常");
        } catch (Exception e) {
            log.error("exception");
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }
}
