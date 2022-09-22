package com.cm.special_enterprise.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface TestService {

    void test(MultipartFile file) throws IOException;

    void test2();
}
