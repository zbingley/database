package com.limai.database.service.impl;

import com.limai.database.dto.PersonSaveReq;
import com.limai.database.repository.PersonRepository;
import com.limai.database.repository.entity.PersonEntity;
import com.limai.database.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;


    @Override
    public PersonEntity save(PersonSaveReq personSaveReq) {
        PersonEntity personEntity = new PersonEntity();
        BeanUtils.copyProperties(personSaveReq,personEntity);
        log.info("person:{}",personEntity);
        PersonEntity save = personRepository.save(personEntity);
        return save;
    }

    @Override
    public PersonEntity getById(int id) {
        Optional<PersonEntity> byId = personRepository.findById(id);
        PersonEntity personEntity = byId.get();
        return personEntity;
    }

    @Override
    public PersonEntity update(PersonSaveReq personSaveReq) {
        PersonEntity personEntity = new PersonEntity();
        BeanUtils.copyProperties(personSaveReq,personEntity);
        personRepository.saveAndFlush(personEntity);
        return null;
    }

    @Override
    public int updateV2(PersonSaveReq personSaveReq) {
        int i = personRepository.updateV2(personSaveReq);
        return i;
    }

    @Override
    public List<PersonEntity> list(String dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime=LocalDateTime.parse(dateTime,formatter);
        long start = System.currentTimeMillis();
        List<PersonEntity> persons = personRepository.findAllByGmtCreateAfter(Timestamp.valueOf(localDateTime));
        log.info("查询完成,耗时："+(System.currentTimeMillis()-start)+"ms");
        return persons;
    }
}
