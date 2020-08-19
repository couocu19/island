package com.dao;

import com.pojo.Dynamics;
import org.apache.ibatis.annotations.Mapper;

//@Mapper
public interface DynamicsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Dynamics record);

    int insertSelective(Dynamics record);

    Dynamics selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Dynamics record);

    int updateByPrimaryKey(Dynamics record);
}