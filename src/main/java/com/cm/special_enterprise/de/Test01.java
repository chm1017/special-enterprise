package com.cm.special_enterprise.de;

import com.alibaba.excel.EasyExcel;
import com.cm.special_enterprise.pojo.DemoEntity;

import java.util.List;

public class Test01 {


    public static void main(String[] args) {

        String filePath = "C:\\Users\\admin\\Desktop\\6666.xlsx";
        List<DemoEntity> list = EasyExcel.read(filePath).head(DemoEntity.class).sheet().doReadSync();
        for (DemoEntity demoEntity : list) {
            System.out.println(demoEntity);
        }
        System.out.println(list.size());
    }
}
