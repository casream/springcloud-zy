package com.cas.service;

import com.cas.pojo.Kanhao;

import java.util.List;

public interface KanhaoServcie {
    int deleteByPrimaryKey(Integer id);

    int insert(Kanhao record);

    Kanhao selectByPrimaryKey(Integer id);

    List<Kanhao> selectAll();

    int updateByPrimaryKey(Kanhao record);
}