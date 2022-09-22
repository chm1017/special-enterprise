package com.cm.special_enterprise.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class TestExcel {
    @ExcelProperty(value = "序号")
    private String id;
    @ExcelProperty(value = "姓名")
    private String name;
    @ExcelProperty(value = "工作单位")
    private String company;
//    @ExcelProperty(value = "职称")
//    private String jobTitle;
//
//    @ExcelProperty(value = "成果")
//    private String achievement;


}
