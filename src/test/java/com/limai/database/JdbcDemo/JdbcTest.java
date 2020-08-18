package com.limai.database.JdbcDemo;

import com.limai.database.common.util.ChineseNameUtils;
import com.limai.database.repository.entity.PersonEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author zhang bin
 * @date 2019/9/26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void test1(){

        List<PersonEntity> people = jdbcTemplate.query("select * from person ", new BeanPropertyRowMapper<>(PersonEntity.class));
        System.out.println(people);
    }

    @Test
    public void testGenerateChineseName(){
        for (int i = 0; i < 10; i++) {
            String name = ChineseNameUtils.randomChineseName();
            System.out.println(name);
        }

    }

}
