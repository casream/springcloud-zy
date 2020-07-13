package com.cas.service.impl;

import com.cas.mapper.TeacherMapper;
import com.cas.pojo.Teacher;
import com.cas.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname TeacherServiceImpl
 * @Description TODO
 * @Date 2020/7/12 23:00
 * @Created by Administrator
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper mapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Teacher record) {
        return mapper.insert(record);
    }

    @Override
    public Teacher selectByPrimaryKey(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Teacher> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Teacher record) {
        return mapper.updateByPrimaryKey(record);
    }

    @Override
    public String errorMessage() {
        int i = 1/0;
        return "exception method in teacher";
    }
}
