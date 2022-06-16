package com.cm.special_enterprise.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DemoDao{

    Integer getCount();
}
