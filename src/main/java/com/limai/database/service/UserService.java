package com.limai.database.service;

import com.limai.database.dto.RegisterReq;
import com.limai.database.repository.entity.UserEntity;

/**
 * @Author: zhangbin
 * @Date: 2018/11/3 9:28
 * @Desc:
 */
public interface UserService {

    void addUser(RegisterReq registerReq);

    UserEntity getUserByMobile(String mobile);

    UserEntity getAndUpdateUserByName(String name,String mobile);

    void removeUserById(String userId);
    void test();
}
