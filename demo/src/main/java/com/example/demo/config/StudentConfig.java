package com.example.demo.config;

import com.example.demo.entity.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 学生配置类
 */
@Configuration
public class StudentConfig {

    @Bean
    public Student student() {
        Student student = new Student();
        student.setId(1L);
        student.setName("张三");
        return student;
    }
}