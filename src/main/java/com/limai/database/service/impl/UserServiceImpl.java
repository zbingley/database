package com.limai.database.service.impl;

import com.limai.database.dto.RegisterReq;
import com.limai.database.repository.entity.UserEntity;
import com.limai.database.service.UserService;
import com.mongodb.client.result.DeleteResult;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * @Author: zhangbin
 * @Date: 2018/11/3 9:29
 * @Desc:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private MongoOperations mongo;

    @Autowired(required = false)
    private RestTemplate restTemplate;
    @Override
    public void addUser(RegisterReq registerReq) {
        String userId = new ObjectId().toString();
        UserEntity userEntity = this.userReq2UserEntity(registerReq, userId);
        mongo.insert(userEntity);

    }

    @Override
    public UserEntity getUserByMobile(String mobile) {
        Query query = new Query(where("mobile").is(mobile));
        UserEntity userEntity = mongo.findOne(query, UserEntity.class);
        return userEntity;
    }

    @Override
    public UserEntity getAndUpdateUserByName(String name,String mobile) {
        Query query = new Query(where("name").is(name));
        Update update = new Update();
        update.set("mobile",mobile);
        UserEntity userEntity = mongo.findAndModify(query, update, UserEntity.class);
        return userEntity;
    }

    @Override
    public void removeUserById(String userId) {
        ObjectId userObjectId = new ObjectId(userId);
        Query query = new Query(where("userId").is(userObjectId));
        DeleteResult remove = mongo.remove(query, UserEntity.class);
        System.out.println(" DeleteResult:"+remove);
    }

    @Override
    public void test() {
        restTemplate.getForObject("127.0.0.1/8081/test",String.class);
    }

    private UserEntity userReq2UserEntity(RegisterReq registerReq,String userId){
        UserEntity userEntity = new UserEntity();
        userEntity.setName(registerReq.getName());
        userEntity.setMobile(registerReq.getMobile());
        ObjectId userObjectId=new ObjectId(userId);
        userEntity.setUserId(userObjectId);
        return userEntity;
    }
}
