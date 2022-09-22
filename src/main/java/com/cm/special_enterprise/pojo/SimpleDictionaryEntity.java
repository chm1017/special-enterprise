package com.cm.special_enterprise.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class SimpleDictionaryEntity {

    private Date createTime;

    private String name;

    private Long parentId;

    private Long id;

    private String remark;

}
