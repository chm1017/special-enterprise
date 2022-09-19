package com.cm.special_enterprise.de;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import cn.hutool.poi.excel.WorkbookUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.cm.special_enterprise.pojo.DemoEntity;
import org.apache.ibatis.javassist.ClassPool;
import org.apache.ibatis.javassist.CtClass;
import org.apache.ibatis.javassist.NotFoundException;
import org.apache.ibatis.javassist.bytecode.ClassFile;
import org.apache.ibatis.javassist.bytecode.ConstPool;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.SheetBuilder;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Map;

public class Test02 {



    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NotFoundException, NoSuchFieldException {

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
        Class<DemoEntity> demoEntityClass = DemoEntity.class;
        Field declaredField = demoEntityClass.getDeclaredField("name");
        ExcelProperty annotation = declaredField.getAnnotation(ExcelProperty.class);
        System.out.println(annotation.value());
        InvocationHandler invocationHandler = Proxy.getInvocationHandler(annotation);
        Field memberValues = invocationHandler.getClass().getDeclaredField("memberValues");
        memberValues.setAccessible(true);
        memberValues.isAccessible();
        Map o = (Map)memberValues.get(invocationHandler);
        o.put("value", "公司");
        System.out.println(o);

        CellRangeAddress cellAddresses = new CellRangeAddress(0, 0, 1, 3);
        EasyExcel.write("C:\\Users\\admin\\Desktop\\444.xlsx", DemoEntity.class).sheet("企业信息").doWrite(list);

    }

}



