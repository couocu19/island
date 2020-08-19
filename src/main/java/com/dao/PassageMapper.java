package com.dao;

import com.pojo.Passage;
import org.apache.ibatis.annotations.Mapper;

//@Mapper
public interface PassageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Passage record);

    int insertSelective(Passage record);

    Passage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Passage record);

    int updateByPrimaryKey(Passage record);
}