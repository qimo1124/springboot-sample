package com.example.demo.controller;

import com.example.demo.common.Result;
import com.example.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private Student student;

    @GetMapping("/getStudent")
    public Result getStudent() {
        return Result.success(student);
    }
}