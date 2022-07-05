package com.cm.special_enterprise.de;

import com.alibaba.excel.EasyExcel;
import com.cm.special_enterprise.pojo.DemoEntity;

import java.util.ArrayList;

public class Test02 {



    public static void main(String[] args) {

        String year = "2021年";
        System.out.println(year.substring(0, 4));
        String a = "万鑫精工（湖南）有限公司";
        System.out.println(a);

        ArrayList<DemoEntity> list = new ArrayList<>();
        String name = "万鑫精工(湖南)有限公司";
        DemoEntity demoEntity = new DemoEntity();
        demoEntity.setName(name);
//        demoEntity.setLevel("市级");
        list.add(demoEntity);
        String name1 = name;
        name1.replaceAll("\\(","（");
        name1.replaceAll("\\)", "）");
        DemoEntity demoEntity1 = new DemoEntity();
        demoEntity1.setName(name);
        list.add(demoEntity1);
        String name2 = name1;
        name2.replaceAll("（","(");
        name2.replaceAll("（", "(");
        DemoEntity demoEntity2 = new DemoEntity();
        demoEntity2.setName(name2);
        list.add(demoEntity2);



        EasyExcel.write("C:\\Users\\admin\\Desktop\\444.xlsx", DemoEntity.class).sheet("企业信息").doWrite(list);
    }
}



