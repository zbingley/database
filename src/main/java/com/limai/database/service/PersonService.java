package com.limai.database.service;

import com.limai.database.dto.PersonSaveReq;
import com.limai.database.repository.entity.PersonEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PersonService {
    PersonEntity save(PersonSaveReq personSaveReq);

    PersonEntity getById(int id);

    PersonEntity update(PersonSaveReq personSaveReq);

    int updateV2(PersonSaveReq personSaveReq);
}
