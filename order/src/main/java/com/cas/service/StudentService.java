package com.cas.service;

import com.cas.pojo.Student;

import java.util.List;

public interface StudentService {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    Student selectByPrimaryKey(Integer id);

    List<Student> selectAll();

    int updateByPrimaryKey(Student record);

    String errorMessage();
}