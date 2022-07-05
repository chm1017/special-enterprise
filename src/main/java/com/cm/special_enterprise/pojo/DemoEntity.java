package com.cm.special_enterprise.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DemoEntity {
    @ExcelProperty(index = 0)
    private String name;
    @ExcelProperty(index = 1)
    private Long level;
}
