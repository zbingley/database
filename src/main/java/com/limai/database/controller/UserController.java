package com.limai.database.controller;

import com.limai.database.common.handler.exception.UserNotFoundException;
import com.limai.database.dto.RegisterReq;
import com.limai.database.repository.entity.UserEntity;
import com.limai.database.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: zhangbin
 * @Date: 2018/11/3 9:24
 * @Desc:
 */
@RestController
@RequestMapping(value = "/users",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public void  addUser(RegisterReq registerReq){
        userService.addUser(registerReq);
    }
    /**
     @GetMapping("")
     public ResponseEntity<UserEntity>  getUser(String mobile){
        UserEntity userByMobile = userService.getUserByMobile(mobile);
        HttpStatus status=userByMobile!=null? HttpStatus.OK:HttpStatus.NOT_FOUND;
        return  new ResponseEntity<UserEntity>(userByMobile,status);
     }
     */
    @GetMapping("")
    public UserEntity  getUser(String mobile){
        UserEntity userByMobile = userService.getUserByMobile(mobile);
        if(null==userByMobile){
           throw  new UserNotFoundException(mobile);
        }
        return  userByMobile;
    }
    @GetMapping(value = "update")
    public UserEntity updateByName(String name,String mobile){
        UserEntity andUpdateUserByName = userService.getAndUpdateUserByName(name,mobile);
        return andUpdateUserByName;
    }
    @DeleteMapping(value = "delete")
    public void deleteUserById(String userId){
        userService.removeUserById(userId);
    }

    @GetMapping("/test1")
    public void test(){
        userService.test();
    }
    @GetMapping("/thread")
    public String  testThread(){
        System.out.println("enter......");
        return "test thread";
    }
}
