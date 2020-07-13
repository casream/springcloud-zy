package com.cas.service.impl;

import com.cas.mapper.StudentMapper;
import com.cas.pojo.Student;
import com.cas.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname StudentServiceImpl
 * @Description TODO
 * @Date 2020/7/13 0:35
 * @Created by Administrator
 */
@Slf4j
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper mapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Student record) {
        return mapper.insert(record);
    }

    @Override
    public Student selectByPrimaryKey(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Student> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Student record) {
        return mapper.updateByPrimaryKey(record);
    }

    @Override
    public String errorMessage() {
        int i = 1 / 0;
        return null;
    }
}
