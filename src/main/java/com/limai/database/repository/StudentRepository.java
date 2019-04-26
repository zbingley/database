package com.limai.database.repository;

import com.limai.database.repository.entity.Student;
import org.springframework.data.repository.CrudRepository;

/**
 * @Author: zhangbin
 * @Date: 2018/11/29 15:22
 * @Desc:
 */
public interface StudentRepository extends CrudRepository<Student,Integer> {

}
