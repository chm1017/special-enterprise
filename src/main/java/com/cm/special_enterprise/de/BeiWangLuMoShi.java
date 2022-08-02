package com.cm.special_enterprise.de;

import com.cm.special_enterprise.pojo.TestEntity;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class BeiWangLuMoShi {
    public static HashMap<String, Object> backupProp(Object bean) {
        HashMap<String, Object> map = new HashMap<>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor des : propertyDescriptors) {
                String fieldName = des.getName();
                Method readMethod = des.getReadMethod();
                Object fieldValue = readMethod.invoke(bean, new Object[]{});
                if (!fieldName.equalsIgnoreCase("class")) {
                    map.put(fieldName, fieldValue);
                }
            }
        } catch (IntrospectionException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return map;
    }

    public static void restoreProp(Object bean , HashMap<String ,Object> map) throws InstantiationException, IllegalAccessException, IntrospectionException, InvocationTargetException {
        BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            String fieldName = propertyDescriptor.getName();
            if (map.containsKey(fieldName)) {
                Method writeMethod = propertyDescriptor.getWriteMethod();
                writeMethod.invoke(bean, new Object[]{map.get(fieldName)});
            }
        }
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, IntrospectionException, InvocationTargetException {
        TestEntity testEntity = new TestEntity();
        testEntity.setSex("1");
        testEntity.setAge("age");
        testEntity.setName("name");
        testEntity.setPhone("123456");
        HashMap<String, Object> map = backupProp(testEntity);
        System.out.println(map);
        TestEntity test = new TestEntity();
        restoreProp(test, map);
        System.out.println(test);

    }


}
