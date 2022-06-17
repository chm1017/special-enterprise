package com.cm.special_enterprise.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface DemoService {
    Integer getCount();

    Boolean improtData(List<MultipartFile> files) throws IOException;
}
