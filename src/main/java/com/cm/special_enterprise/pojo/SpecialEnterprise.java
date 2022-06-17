package com.cm.special_enterprise.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Accessors(chain = true)
@TableName("d_special_enterprise6")
@Entity
public class SpecialEnterprise {
    @Id
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("create_time")
    private Date create_time;

    @TableField("create_user_id")
    private Long create_user_id;

    @TableField("deleted")
    private Integer deleted;

    @TableField("department_id")
    private Long department_id;

    @TableField("update_time")
    private Date update_time;

    @TableField("update_user_id")
    private Date update_user_id;

    @TableField("uuid")
    private String uuid;

    @TableField("version")
    private Integer version;

    @TableField("area_id")
    private Long area_id;

    @TableField("city_id")
    private Long city_id;

    @TableField("province_id")
    private Long province_id;

    @TableField("street_id")
    private Long street_id;

    @TableField("code")
    private String code;

    @TableField("level")
    private String level;

    @TableField("name")
    private String name;

    @TableField("year")
    private Integer year;

    @TableField("hat_name")
    private String hat_name;


}
