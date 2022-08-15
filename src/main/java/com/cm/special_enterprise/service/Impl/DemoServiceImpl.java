package com.cm.special_enterprise.service.Impl;

import cn.hutool.poi.excel.ExcelUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.excel.util.WorkBookUtil;
import com.cm.special_enterprise.dao.DemoDao;
import com.cm.special_enterprise.dao.SpecialEnterpriseDao;
import com.cm.special_enterprise.pojo.DemoEntity;
import com.cm.special_enterprise.pojo.EnterpriseBaseIndex;
import com.cm.special_enterprise.pojo.SpecialEnterprise;
import com.cm.special_enterprise.service.DemoService;


import org.apache.poi.ss.usermodel.Workbook;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoDao demoDao;

    @Autowired
    private SpecialEnterpriseDao specialEnterpriseDao;

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;
    @Override
    public Integer getCount() {
        return demoDao.getCount();
    }

    @Override
    public Boolean improtData(List<MultipartFile> files) throws IOException {
        ArrayList<DemoEntity> demoEntities = new ArrayList<>();
        ArrayList<DemoEntity> existEntities = new ArrayList<>();

        new HashMap<String, HashMap<String, String>>();

        for (MultipartFile file : files) {

            List<String> sheetNames = ExcelUtil.getReader(file.getInputStream()).getSheetNames();
            for (String sheetName:sheetNames) {
                List<DemoEntity> list = EasyExcel.read(file.getInputStream()).sheet(sheetName).head(DemoEntity.class).doReadSync();
                for (DemoEntity demoEntity:list) {
                    if (demoEntity.getName() != null) {
                        String name = demoEntity.getName().replace((char)12288,' ').trim();
                        String name1= name.replaceAll("\\(","（");
                        String name2 = name1.replaceAll("\\)", "）");
                        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
                        queryBuilder.withQuery(QueryBuilders.termQuery("name.keyword", name2));
                        SearchHits<EnterpriseBaseIndex> searchHits = elasticsearchRestTemplate.search(queryBuilder.build(), EnterpriseBaseIndex.class);
                        if (searchHits.getTotalHits() == 0) {
                            queryBuilder.withQuery(QueryBuilders.termQuery("oldName", name2));
                            searchHits = elasticsearchRestTemplate.search(queryBuilder.build(), EnterpriseBaseIndex.class);
                        }

                        if (searchHits.getTotalHits() == 0) {
                            String name3=name2.replace("（","\\(");
                            String name4 = name3.replace("）", "\\)");
                            queryBuilder.withQuery(QueryBuilders.termQuery("name.keyword", name4));
                            searchHits = elasticsearchRestTemplate.search(queryBuilder.build(), EnterpriseBaseIndex.class);
                            if (searchHits.getTotalHits() == 0) {
                                queryBuilder.withQuery(QueryBuilders.termQuery("oldName", name4));
                                searchHits = elasticsearchRestTemplate.search(queryBuilder.build(), EnterpriseBaseIndex.class);
                            }
                        }
                        if (searchHits.getTotalHits() == 0) {
                            System.out.println(name);
                            if ("企业名称".equals(name)) {
                                continue;
                            }
                            demoEntities.add(demoEntity);
                        }
                        if (searchHits.getTotalHits() !=0) {
                            searchHits.getSearchHits().forEach(e->{
                                SpecialEnterprise enterprise1 = specialEnterpriseDao.selectByName(name);
                                SpecialEnterprise enterprise2 = specialEnterpriseDao.selectByCode(e.getContent().getCode());
                                if (enterprise1 == null && enterprise2 == null) {
                                    SpecialEnterprise specialEnterprise = new SpecialEnterprise();
                                    specialEnterprise.setCode(e.getContent().getCode());
                                    specialEnterprise.setArea_id(e.getContent().getAreaId());
                                    specialEnterprise.setCity_id(e.getContent().getCityId());
                                    specialEnterprise.setProvince_id(e.getContent().getProvinceId());
                                    specialEnterprise.setStreet_id(e.getContent().getStreetId());
//                                    specialEnterprise.setLevel(demoEntity.getLevel());
                                    specialEnterprise.setYear(Integer.parseInt(sheetName.substring(0,4)));
                                    specialEnterprise.setName(name);
                                    specialEnterprise.setHat_name("专精特新中小型企业");
                                    specialEnterprise.setCreate_time(new Date());
                                    specialEnterpriseDao.insert(specialEnterprise);
                                } else {
                                    existEntities.add(demoEntity);
                                }
                            });
                        }

                    }

                }
            }
        }
        System.out.println("======="+demoEntities.toString());
        EasyExcel.write("C:\\Users\\admin\\Desktop\\555.xlsx", DemoEntity.class).sheet("企业信息").doWrite(demoEntities);
        EasyExcel.write("C:\\Users\\admin\\Desktop\\777.xlsx", DemoEntity.class).sheet("已存在企业").doWrite(existEntities);
        return true;
    }


}
