package com.limai.database.repository;

import com.limai.database.dto.PersonSaveReq;
import com.limai.database.repository.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

public interface PersonRepository extends JpaRepository<PersonEntity,Integer> {
    @Modifying
    @Transactional
    @Query(value = "update PersonEntity p set p.name=:#{#personSaveReq.name}," +
            "p.age=:#{#personSaveReq.age}," +
            "p.gender=:#{#personSaveReq.gender} " +
            "where p.id=:#{#personSaveReq.id}")
    int updateV2(@Param("personSaveReq") PersonSaveReq personSaveReq);

    List<PersonEntity> findAllByGmtCreateAfter(Timestamp gmtCreate);
}
