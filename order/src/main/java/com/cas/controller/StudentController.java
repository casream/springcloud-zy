package com.cas.controller;

import com.cas.pojo.Student;
import com.cas.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Classname TecherController
 * @Description TODO
 * @Date 2020/7/12 23:03
 * @Created by Administrator
 */
@RestController
@RequestMapping("/student")
@Slf4j
public class StudentController implements StudentService {
    @Autowired
    private StudentService studentService;

    @Value("${server.port}")
    int port;


    @Override
    @RequestMapping("/deleteByPrimaryKey")
    public int deleteByPrimaryKey(@RequestParam("id") Integer id) {
        log.info("======================student deleteByPrimaryKey=======================");
        return studentService.deleteByPrimaryKey(id);
    }

    @Override
    @RequestMapping("/insert")
    public int insert(@RequestBody Student record) {
        log.info("=====================student insert=======================");
        return studentService.insert(record);
    }

    @Override
    @RequestMapping("/selectByPrimaryKey")
    public Student selectByPrimaryKey(@RequestParam("id") Integer id) {
        log.info("=====================student selectByPrimaryKey=======================");
        return studentService.selectByPrimaryKey(id);
    }

    @Override
    @RequestMapping("/selectAll")
    public List<Student> selectAll() {
        log.info("======================selectAll selectAll=======================");
        return studentService.selectAll();
    }

    @Override
    @RequestMapping("/updateByPrimaryKey")
    public int updateByPrimaryKey(@RequestBody  Student record) {
        log.info("=====================studentupdateByPrimaryKey=======================");
        return studentService.updateByPrimaryKey(record);
    }

    @Override
    @RequestMapping("/errorMessage")
    public String errorMessage() {
        log.info("=====================studenterrorMessage=======================");
        return studentService.errorMessage();
    }
}
