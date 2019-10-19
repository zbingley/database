package com.limai.database.controller;

import com.limai.database.common.BaseResponse;
import com.limai.database.common.annotation.AutoParamValidate;
import com.limai.database.common.dto.SubmitStudentRequest;
import com.limai.database.repository.entity.Student;
import com.limai.database.service.StudentService;
import com.limai.database.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: zhangbin
 * @Date: 2018/11/29 15:26
 * @Desc:
 */
@Slf4j
@RestController
@RequestMapping(value = "/teacher",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;
    @GetMapping("/save")
    public Student  saveStudent(String name){
        Student student = new Student(name);
        try {
            studentService.saveStudent(student);
        } catch (Exception e) {
            System.out.println("异常");
        }
        return student;
    }
    @AutoParamValidate
    @PostMapping("/save/v2")
    public BaseResponse<Boolean> saveStudentV2(@RequestBody SubmitStudentRequest submitStudentRequest){
        BaseResponse<Boolean> response = new BaseResponse<>();
        Student student = new Student(submitStudentRequest.getName());
        boolean saveSuccess = studentService.saveStudentV2(student);
        if(!saveSuccess){
            response.setCode(10001);
            response.setMsg("保存student失败");
            return response;
        }
        response.setData(saveSuccess);
        return response;
    }
    /*
    * /teacher/save/v3?name="aa",用实体对象也能接收到URL上的参数
    * */
    @PostMapping("/save/v3")
    public BaseResponse<Boolean> saveStudentV3(SubmitStudentRequest submitStudentRequest){
        BaseResponse<Boolean> response = new BaseResponse<>();
        Student student = new Student(submitStudentRequest.getName());
        boolean saveSuccess = studentService.saveStudentV2(student);
        if(!saveSuccess){
            response.setCode(10001);
            response.setMsg("保存student失败");
            return response;
        }
        response.setData(saveSuccess);
        return response;
    }
    @GetMapping("/saveV2")
    public Student  saveV2Teacher(String name,String teName,String id){
        Student student = new Student(name);
        try {
            teacherService.saveV2Teacher(student,id,teName);
        } catch (Exception e) {
            log.error("异常===========");
        }
        return student;
    }
}
