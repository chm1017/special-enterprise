package com.cm.special_enterprise.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DemoEntity {
    @ExcelProperty(value = "公司名称")
    private String name;
    @ExcelProperty(value = "等级")
    private Long level;
}
