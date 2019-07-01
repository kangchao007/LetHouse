package com.whhp.service.impl;

import com.whhp.entity.Type;
import com.whhp.entity.TypeExample;
import com.whhp.mapper.TypeMapper;
import com.whhp.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    public int insert(Type record) {
        return 0;
    }

    public int insertSelective(Type record) {
        return 0;
    }

    public List<Type> selectByExample(TypeExample example) {
        return null;
    }

    public Type selectByPrimaryKey(Integer id) {
        return null;
    }

    public int updateByPrimaryKeySelective(Type record) {
        return 0;
    }

    public int updateByPrimaryKey(Type record) {
        return 0;
    }

    public List<Type> getAllType() {
        return typeMapper.selectByExample(new TypeExample());
    }
}
