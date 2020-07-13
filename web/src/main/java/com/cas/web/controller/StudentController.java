package com.cas.web.controller;

import com.cas.pojo.Student;
import com.cas.web.service.base.StudentServiceBase;
import com.cas.web.service.feign.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Classname StudentController
 * @Description TODO
 * @Date 2020/7/13 0:42
 * @Created by Administrator
 */
@RestController
@RequestMapping("/student")
@Slf4j
public class StudentController implements StudentServiceBase {
    @Autowired
    private StudentService service;

    @Override
    public int deleteByPrimaryKey(@RequestParam Integer id) {
        log.info("=====================student deleteByPrimaryKey=======================");

        return service.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(@RequestBody Student record) {
        log.info("=====================student insert=======================");
        return service.insert(record);
    }

    @Override
    public Student selectByPrimaryKey(@RequestParam("id") Integer id) {
        log.info("=====================student selectByPrimaryKey=======================");
        return service.selectByPrimaryKey(id);
    }

    @Override
    public List<Student> selectAll() {
        log.info("=====================student selectAll=======================");
        return service.selectAll();
    }

    @Override
    public int updateByPrimaryKey(@RequestBody Student record) {
        log.info("=====================student updateByPrimaryKey=======================");
        return service.updateByPrimaryKey(record);
    }

    @Override
    public String errorMessage() {
        log.info("=====================student errorMessage=======================");
        return service.errorMessage();
    }
}
