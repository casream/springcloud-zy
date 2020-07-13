package com.cas.mapper;

import com.cas.pojo.Kanhao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


public interface KanhaoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Kanhao record);

    Kanhao selectByPrimaryKey(Integer id);

    List<Kanhao> selectAll();

    int updateByPrimaryKey(Kanhao record);
}