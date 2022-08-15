package com.cm.special_enterprise.controller;

import com.alibaba.excel.EasyExcel;
import com.cm.special_enterprise.dao.SimpleDictionaryMapper;
import com.cm.special_enterprise.excel.DicExcel;
import com.cm.special_enterprise.pojo.EnterpriseBaseIndex;
import com.cm.special_enterprise.pojo.SimpleDictionaryEntity;
import com.cm.special_enterprise.service.DemoService;

import com.cm.special_enterprise.service.TestService;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@RestController
public class DemoController {
    ///test大大大大大大
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


}
