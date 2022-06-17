package com.cm.special_enterprise.de;

import com.alibaba.excel.EasyExcel;
import com.cm.special_enterprise.pojo.DemoEntity;

import java.util.ArrayList;

public class Test02 {



    public static void main(String[] args) {
        DemoEntity demoEntity = new DemoEntity();
        demoEntity.setName("66666");
        demoEntity.setLevel("市级");
        ArrayList<DemoEntity> DEMO_ENTITIES = new ArrayList<>();
        DEMO_ENTITIES.add(demoEntity);
        EasyExcel.write("C:\\Users\\admin\\Desktop\\444.xlsx", DemoEntity.class).sheet("企业信息").doWrite(DEMO_ENTITIES);

    }
}



