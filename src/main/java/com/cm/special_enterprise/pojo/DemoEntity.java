package com.cm.special_enterprise.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DemoEntity {
    @ExcelProperty(value = "企业名称")
    private String name;
    @ExcelProperty(value = "级别")
    private String level;
}
