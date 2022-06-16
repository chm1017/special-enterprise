package com.cm.special_enterprise.service.Impl;

import com.cm.special_enterprise.dao.DemoDao;
import com.cm.special_enterprise.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoDao demoDao;

    @Override
    public Integer getCount() {
        return demoDao.getCount();
    }

}
