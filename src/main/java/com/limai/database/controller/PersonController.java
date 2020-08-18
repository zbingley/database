package com.limai.database.controller;

import com.limai.database.common.BaseResponse;
import com.limai.database.dto.PersonSaveReq;
import com.limai.database.repository.entity.PersonEntity;
import com.limai.database.service.AsyncService;
import com.limai.database.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/persons", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Slf4j
public class PersonController {
    @Autowired
    private PersonService personService;
    @Autowired
    private AsyncService asyncService;

    @PostMapping("/save")
    public BaseResponse<PersonEntity> save(@RequestBody PersonSaveReq personSaveReq, HttpServletRequest request) throws IOException {
        log.info("person:{}", personSaveReq);
     /*   System.out.println("----------------");
        System.out.println(IOUtils.toString(request.getInputStream(),"UTF-8"));
        System.out.println("----------------");*/
        PersonEntity save = personService.save(personSaveReq);
        BaseResponse<PersonEntity> response = new BaseResponse<>();
        response.setData(save);
//        asyncService.asyncExecuteService();
        return response;
    }

    @GetMapping("/{id}")
    public BaseResponse<PersonEntity> getById(@PathVariable String id) {
        Integer idReq = Integer.valueOf(id);
        PersonEntity byId = personService.getById(idReq);
        BaseResponse<PersonEntity> response = new BaseResponse<>();
        response.setData(byId);
        return response;
    }

    @PostMapping("/update")
    public BaseResponse<PersonEntity> update(@RequestBody PersonSaveReq personSaveReq) {
        log.info("person:{}", personSaveReq);
        PersonEntity save = personService.update(personSaveReq);
        BaseResponse<PersonEntity> response = new BaseResponse<>();
        response.setData(save);
        return response;
    }

    @PostMapping("/update/v2")
    public BaseResponse<Integer> updateV2(@RequestBody PersonSaveReq personSaveReq) {
        log.info("person:{}", personSaveReq);
        int i = personService.updateV2(personSaveReq);
        BaseResponse<Integer> response = new BaseResponse<>();
        response.setData(i);
        return response;
    }

    /*
     * 使用@RequestParam(name = "")注解接收请求参数时，如果该参数前端传了多个同名的，接收到的参数会以逗号隔开,
     *  /persons/get/v2?id=236&id=45 使用httpServletRequest.getParameter("id")拿到的是第一个 236
     * */
    @GetMapping("/get")
    public void getPerson(@RequestParam(name = "id") String id) {
        System.out.println("id:" + id);
    }

    @GetMapping("/get/v2")
    public void getPersonV2(HttpServletRequest request) {
        String id = request.getParameter("id");
        System.out.println("id:" + id);
    }

    /**
     * 测试数据库 querytimeout
     *
     * @param dateTime yyyy-MM-dd HH:mm:ss
     * @return persons
     */
    @PostMapping("/list/all")
    public List<PersonEntity> listPersons(String dateTime) {
        return personService.list(dateTime);
    }
}
