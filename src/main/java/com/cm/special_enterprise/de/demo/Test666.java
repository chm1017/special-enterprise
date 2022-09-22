package com.cm.special_enterprise.de.demo;

import com.alibaba.excel.util.DateUtils;
import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.config.Configure;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Test666 {

    @RequestMapping(value = "/importTemplateRH", method = RequestMethod.POST)
    public void generateWorkContactLetters(HttpServletResponse response,
                                           @RequestParam(value = "companyAndName") String companyAndName,
                                           @RequestParam(value = "work") String work) throws Exception {
        //获取当前的日期
        Date date = new Date();
        //设置要获取到什么样的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //获取String类型的时间
        String createdate = sdf.format(date);
        /** 初始化配置文件 **/
//        @SuppressWarnings("deprecation")
        Configuration configuration = new Configuration();
        configuration.setDefaultEncoding("utf-8");
        /** 加载模板 **/

        //这个方法在eclipse跑和打jar包部署都可以获取到模版
        configuration.setClassForTemplateLoading(this.getClass(), "/templates");
        Template template = configuration.getTemplate("test.ftl");
        //这里是我获取的业务对象
        Map<String, Object> dataMap = new HashMap<>();

        dataMap.put("work", work);
        dataMap.put("companyAndName",companyAndName);
        dataMap.put("date", createdate == null ? "-" : String.valueOf(new Date()));
        //开始word导出：导出我没有写死导出到什么磁盘，是通过浏览器输出随意存放修改。
        ServletOutputStream out = null;
        FileInputStream fin = null;
        String fileName = "报告.doc";
        try {


            //utils里创建word的方法：后面会给出代码
            File wordFile = WordUtil.createDoc(dataMap, template);
            fin = new FileInputStream(wordFile);
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/msword;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename=\"" + URLEncoder.encode(fileName, "UTF-8") + "\"");
            out = response.getOutputStream();

            byte[] buffer = new byte[1024];// 缓冲区
            int bytesToRead = -1;
            // 通过循环将读入的Word文件的内容输出到浏览器中
            while ((bytesToRead = fin.read(buffer)) != -1) {
                out.write(buffer, 0, bytesToRead);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (fin != null)
                fin.close();
            if (out != null)
                out.close();
        }
    }










}
