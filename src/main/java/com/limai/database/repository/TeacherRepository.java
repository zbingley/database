package com.limai.database.repository;

import com.limai.database.repository.entity.Student;
import com.limai.database.repository.entity.Teacher;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: zhangbin
 * @Date: 2018/11/29 15:22
 * @Desc:
 */
public interface TeacherRepository extends CrudRepository<Teacher,Integer> {
    @Modifying
    @Transactional
    @Query(value = "update teacher set name=?2 where id= ?1",nativeQuery = true)
    int updateTeacherById(String  id,String name);

}
