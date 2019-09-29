package com.limai.database.controller;

import com.limai.database.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/async")
public class AsyncController {
    @Autowired
    private AsyncService asyncService;

    @GetMapping("/demo")
    public void async(){
        asyncService.asyncExecuteService();
    }
}
