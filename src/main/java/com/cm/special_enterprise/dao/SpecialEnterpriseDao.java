package com.cm.special_enterprise.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cm.special_enterprise.pojo.SpecialEnterprise;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SpecialEnterpriseDao extends BaseMapper<SpecialEnterprise> {

    @Select("select * from d_special_enterprise6 where name = #{name}")
    SpecialEnterprise selectByName(String name);

    @Select("select * from d_special_enterprise6 where code = #{code}")
    SpecialEnterprise selectByCode(String code);

}
