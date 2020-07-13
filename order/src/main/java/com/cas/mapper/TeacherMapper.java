package com.cas.mapper;

import com.cas.pojo.Teacher;
import java.util.List;

public interface TeacherMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Teacher record);

    Teacher selectByPrimaryKey(Integer id);

    List<Teacher> selectAll();

    int updateByPrimaryKey(Teacher record);
}