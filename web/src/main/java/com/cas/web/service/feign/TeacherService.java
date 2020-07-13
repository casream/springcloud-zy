package com.cas.web.service.feign;

import com.cas.pojo.Teacher;

import java.util.List;

public interface TeacherService {
    int deleteByPrimaryKey(Integer id);

    int insert(Teacher record);

    Teacher selectByPrimaryKey(Integer id);

    List<Teacher> selectAll();

    int updateByPrimaryKey(Teacher record);
    String errorMessage();
}