package com.cas.controller;

import com.cas.pojo.Teacher;
import com.cas.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Classname TecherController
 * @Description TODO
 * @Date 2020/7/12 23:03
 * @Created by Administrator
 */
@RestController
@RequestMapping("/teacher")
@Slf4j
public class TecherController implements TeacherService {
    @Autowired
    private TeacherService teacherService;

    @Override
    @RequestMapping("/deleteByPrimaryKey")
    public int deleteByPrimaryKey(@RequestParam("id") Integer id) {
        log.info("======================selectAll deleteByPrimaryKey=======================");
        return teacherService.deleteByPrimaryKey(id);
    }

    @Override
    @RequestMapping("/insert")
    public int insert(@RequestBody Teacher record) {
        log.info("======================selectAll insert=======================");
        return teacherService.insert(record);
    }

    @Override
    @RequestMapping("/selectByPrimaryKey")
    public Teacher selectByPrimaryKey(@RequestParam Integer id) {
        log.info("======================selectAll selectByPrimaryKey=======================");
        return teacherService.selectByPrimaryKey(id);
    }

    @Override
    @RequestMapping("/selectAll")
    public List<Teacher> selectAll() {
        log.info("======================selectAll selectAll=======================");
        return teacherService.selectAll();
    }

    @Override
    @PostMapping("/updateByPrimaryKey")
    public int updateByPrimaryKey(@RequestBody Teacher record) {
        log.info("======================selectAll updateByPrimaryKey=======================");
        return teacherService.updateByPrimaryKey(record);
    }

    @Override
    @GetMapping("/errorMessage")
    public String errorMessage() {
        log.info("======================selectAll errorMessage=======================");

        return teacherService.errorMessage();
    }
}
