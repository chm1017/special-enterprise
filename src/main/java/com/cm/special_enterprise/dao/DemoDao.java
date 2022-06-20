package com.cm.special_enterprise.dao;

import com.cm.special_enterprise.pojo.SpecialEnterprise;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DemoDao{


@Select("select count(*) from d_special_enterprise")
    Integer getCount();

}
