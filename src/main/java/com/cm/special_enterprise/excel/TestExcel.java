package com.cm.special_enterprise.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class TestExcel {
    @ExcelProperty(value = "name")
    private String name;
    @ExcelProperty(value = "code")
    private String code;

}
