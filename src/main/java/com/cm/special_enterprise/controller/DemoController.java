package com.cm.special_enterprise.controller;

import com.alibaba.excel.EasyExcel;
import com.cm.special_enterprise.dao.SimpleDictionaryMapper;
import com.cm.special_enterprise.de.demo.WordUtil;
import com.cm.special_enterprise.excel.DicExcel;
import com.cm.special_enterprise.pojo.EnterpriseBaseIndex;
import com.cm.special_enterprise.pojo.SimpleDictionaryEntity;
import com.cm.special_enterprise.service.DemoService;

import com.cm.special_enterprise.service.TestService;
import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.config.Configure;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Field;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class DemoController {
    ///test大
    @Autowired
    private DemoService demoService;
    @Autowired
    private TestService testService;

    @Autowired
    private SimpleDictionaryMapper simpleDictionaryMapper;

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @RequestMapping("/hello")
    public Integer hello() {
        return demoService.getCount();
    }


    /*
    //导入数据
     */
    @RequestMapping("/importData")
    public Boolean importData(@RequestParam(name = "files") List<MultipartFile> files) throws IOException {
        return demoService.improtData(files);
    }


    @GetMapping("/es")
    public EnterpriseBaseIndex get() {

        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
//        nativeSearchQueryBuilder.withQuery(QueryBuilders.termQuery("name.keyword", "null"));
        SearchHits<EnterpriseBaseIndex> searchHits = elasticsearchRestTemplate.search(nativeSearchQueryBuilder.build(), EnterpriseBaseIndex.class);
        searchHits.getSearchHits().forEach(e -> {
            System.out.println(e.getContent().getName());
            System.out.println(e.getContent().getCode());
        });
        return searchHits.getSearchHit(0).getContent();
    }

    @GetMapping("test")
    public Boolean test(MultipartFile file) throws IOException {
        testService.test(file);
        return true;
    }
    @GetMapping("test2")
    public Boolean test() throws IOException {
        testService.test2();
        return true;
    }


    @PostMapping(value = "importDic")
    public void importDic(MultipartFile file) {
        try {
            List<DicExcel> dicExcels = EasyExcel.read(file.getInputStream()).head(DicExcel.class).sheet().doReadSync();
            for (DicExcel dicExcel : dicExcels) {
                SimpleDictionaryEntity simpleDictionaryEntity = new SimpleDictionaryEntity();
                simpleDictionaryEntity.setName(dicExcel.getKey());
                simpleDictionaryEntity.setParentId(1721L);
                simpleDictionaryEntity.setRemark("赣州新增人才字段");
                simpleDictionaryEntity.setCreateTime(new Date());
                simpleDictionaryMapper.insert(simpleDictionaryEntity);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    @RequestMapping(value = "/importTemplateRH", method = RequestMethod.GET)
    public void generateWorkContactLetters(HttpServletResponse response,
                                           @RequestParam(value = "companyAndName") String companyAndName,
                                           @RequestParam(value = "work") String work) throws Exception {
        //获取当前的日期
        Date date = new Date();
        //设置要获取到什么样的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //获取String类型的时间
        String createdate = sdf.format(date);
        Configuration configuration = new Configuration();
        configuration.setDefaultEncoding("utf-8");
        configuration.setClassForTemplateLoading(this.getClass(), "/templates");
        Template template = configuration.getTemplate("test.ftl");
        Map<String, String> dataMap = new HashMap<>();
        dataMap.put("date",createdate);
        ServletOutputStream out = null;
        FileInputStream fin = null;
        String fileName = "报告.doc";
        try {
//            File wordFile = WordUtil.createDoc(dataMap, template);
            File f = new File(fileName);
            Writer w = new OutputStreamWriter(new FileOutputStream(f), "utf-8");
            template.process(dataMap, w);
            w.close();
            fin = new FileInputStream(f);
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

    @RequestMapping(value = "/importTemplateRH2", method = RequestMethod.GET)
    public void generateWorkContactLetters2(HttpServletResponse response,
                                           @RequestParam(value = "companyAndName") String companyAndName,
                                           @RequestParam(value = "work") String work) throws Exception {
        try {
            String downloadFilename = UUID.randomUUID()+".docx";//文件的名称
            downloadFilename = URLEncoder.encode(downloadFilename, "UTF-8");//转换中文否则可能会产生乱码

            response.reset();
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/octet-stream;charset=utf-8");//octet-stream支持所有以流形势输出的文
            response.setHeader("Content-disposition", "attachment;filename=" +downloadFilename );
            Map<String, Object> datas = new HashMap<String, Object>() {{
                put("date", "111");
                put("work","work");
                put("companyAndName", "companyAndName");
            }};

            //render
            XWPFTemplate template = XWPFTemplate.compile("src/main/resources/templates/work.ftl").render(datas);//将数据填充到模板
            ServletOutputStream out = response.getOutputStream();
            template.write(out);//将流写进outputstream流中
            template.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }







}
