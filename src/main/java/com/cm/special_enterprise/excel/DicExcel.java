package com.cm.special_enterprise.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class DicExcel {
    @ExcelProperty(index = 0)
    private String key;
}
