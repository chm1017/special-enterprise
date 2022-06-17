package com.cm.special_enterprise.controller;

import com.cm.special_enterprise.pojo.EnterpriseBaseIndex;
import com.cm.special_enterprise.service.DemoService;

import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class DemoController {
    @Autowired
    private DemoService demoService;

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
        nativeSearchQueryBuilder.withQuery(QueryBuilders.termQuery("name.keyword", "厦门一泰消防科技开发有限公司北京分公司"));
        SearchHits<EnterpriseBaseIndex> searchHits = elasticsearchRestTemplate.search(nativeSearchQueryBuilder.build(), EnterpriseBaseIndex.class);
        searchHits.getSearchHits().forEach(e -> {
            System.out.println(e.getContent().getName());
            System.out.println(e.getContent().getCode());
        });
        return searchHits.getSearchHit(0).getContent();
    }

}
