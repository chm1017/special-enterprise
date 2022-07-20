package com.cm.special_enterprise.service.Impl;

import com.alibaba.excel.EasyExcel;
import com.cm.special_enterprise.pojo.TestExcel;
import com.cm.special_enterprise.service.TestService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {


    @Override
    public void test(MultipartFile file) throws IOException {
        List<TestExcel> testList = EasyExcel.read(file.getInputStream()).head(TestExcel.class).sheet().doReadSync();
        List<TestExcel> testExcels = new ArrayList<>();
        for (TestExcel testExcel : testList) {
            if (testExcel.getName() != null && testExcel.getCompany() != null) {
                String s=testExcel.getCompany().replaceAll(" ", "");
                String name = testExcel.getName().replaceAll(" ", "").replaceAll("A", "").replaceAll("B","");
                testExcel.setCompany(s);
                testExcel.setName(name);
                System.out.println(testExcel);
                testExcels.add(testExcel);

            }
        }
        System.out.println(testExcels.size());
    }

    @Override
    public void test2() {

    }
}
