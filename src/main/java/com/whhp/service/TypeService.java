package com.whhp.service;

import com.whhp.entity.Type;
import com.whhp.entity.TypeExample;

import java.util.List;

public interface TypeService {
    int deleteByPrimaryKey(Integer id);

    int insert(com.whhp.entity.Type record);

    int insertSelective(com.whhp.entity.Type record);

    List<com.whhp.entity.Type> selectByExample(TypeExample example);

    com.whhp.entity.Type selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(com.whhp.entity.Type record);

    int updateByPrimaryKey(com.whhp.entity.Type record);

    List<Type> getAllType();

}
