package com.cm.special_enterprise.de.thread;

import com.cm.special_enterprise.pojo.TestEntity;

import java.io.*;

public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        TestEntity testEntity = new TestEntity();
        testEntity.setName("ke");
        testEntity.setSex("2");
        testEntity.setPhone("66666");
        testEntity.setAge(22);
        FileOutputStream fileOutputStream = new FileOutputStream("D:/data.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(testEntity);
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("D:/data.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        TestEntity o = (TestEntity)objectInputStream.readObject();
        System.out.println(o.toString());
        DemoRunnable demoRunnable = new DemoRunnable();



    }

}
