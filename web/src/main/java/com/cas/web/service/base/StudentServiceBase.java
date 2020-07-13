package com.cas.web.service.base;

import com.cas.pojo.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Classname StudentServiceBase
 * @Description TODO
 * @Date 2020/7/13 0:42
 * @Created by Administrator
 */
public interface StudentServiceBase {
    @PostMapping("/deleteByPrimaryKey")
    public int deleteByPrimaryKey(@RequestParam("id") Integer id);

    @PostMapping("/insert")
    public int insert(@RequestBody Student record);

    @GetMapping("/selectByPrimaryKey")
    Student selectByPrimaryKey(@RequestParam("id") Integer id);

    @GetMapping("/selectAll")
    List<Student> selectAll();

    @PostMapping("/updateByPrimaryKey")
    int updateByPrimaryKey(@RequestBody Student record);

    @GetMapping("/errorMessage")
    String errorMessage();
}
