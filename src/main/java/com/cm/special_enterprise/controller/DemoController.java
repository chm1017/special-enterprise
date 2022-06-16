package com.cm.special_enterprise.controller;

import com.cm.special_enterprise.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {

    @Autowired
    private DemoService demoService;

    @ResponseBody
    @RequestMapping("/hello")
    public Integer  hello() {
        return demoService.getCount();
    }

}
