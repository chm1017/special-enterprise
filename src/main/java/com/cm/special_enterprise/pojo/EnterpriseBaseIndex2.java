package com.cm.special_enterprise.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.*;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import java.util.Date;

/**
 * 企业索引
 */


@Document(indexName = "qc_enterprise_index2", createIndex = true, useServerConfiguration = true)

@Data
public class EnterpriseBaseIndex2 extends BaseMapping {


    /**
     * 企业名,同时支持模糊和精确查询
     */
    @MultiField(mainField = @Field(type = FieldType.Text), otherFields = {
            @InnerField(type = FieldType.Keyword, suffix = "keyword") })
    private String name;

    /**
     * 社会统一信用代码
     */
    @Field(type = FieldType.Keyword)
    private String code;

    //企业logo
    @Field(type = FieldType.Keyword)
    private String imageUrl;


    //企业注册时间
    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss||yyyy-MM-dd||epoch_millis")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date registerDate;

    //所属国家
    @Field(type = FieldType.Long)
    private Long countryId;

    //省份id
    @Field(type = FieldType.Long)
    private Long provinceId;

    //市 id
    @Field(type = FieldType.Long)
    private Long cityId;

    //区 id
    @Field(type = FieldType.Long)
    private Long areaId;

    //街道 id
    @Field(type = FieldType.Long)
    private Long streetId;

    //街道名称
    @Field(type = FieldType.Text)
    private String street;

    //详细地址
    @Field(type = FieldType.Text)
    private String address;


    @GeoPointField
    private GeoPoint location;


    //注册地址
    @Field(type = FieldType.Text)
    private String registerAddress;

    //公司网址
    @Field(type = FieldType.Keyword)
    private String web;

    //注册资本字符串
    @Field(type = FieldType.Keyword)
    private String registerMoney;

    //企业收入规模
    @Field(type = FieldType.Long)
    private Long enterpriseIncomeScale;

    //注册类型
    @Field(type = FieldType.Keyword)
    private String registerType;

    @Field(type = FieldType.Integer)
    private Integer grantedInventNum = 0; //授权发明数
    @Field(type = FieldType.Integer)
    private Integer acceptancedInventNum = 0;//受理,申请发明数
    @Field(type = FieldType.Integer)
    private Integer grantUtilityModelNum = 0; //授权实用新型数
    @Field(type = FieldType.Integer)
    private Integer applyUtilityModelNum = 0; // 申请实用新型数
    @Field(type = FieldType.Integer)
    private Integer softWorkNum = 0;//软件著作数
    @Field(type = FieldType.Integer)
    private Integer appearance = 0; //外观专利数

    @Field(type = FieldType.Integer)
    private Integer grantedAppearanceNum = 0; // 授权外观数
    @Field(type = FieldType.Integer)
    private Integer applyAppearanceNum = 0; // 申请外观数

    @Field(type = FieldType.Integer)
    private Integer intellectualNum = 0;//知产总量

    @Field(type = FieldType.Keyword)
    private String isHighlyEnterpriseYearAndInfo = ""; //成为高企年份及相关信息
    @Field(type = FieldType.Keyword)
    private String isBreedEnterpriseYearAndInfo = ""; // 成为培育企业年份及相关信息
    @Field(type = FieldType.Keyword)
    private String hasDevelopCoorYearAndInfo = ""; //成立研发机构年份及相关信息
    @Field(type = FieldType.Keyword)
    private String isProvinceOwnEnterpriseYearAndInfo = "";//成为省民营企业年 及相关信息
    @Field(type = FieldType.Keyword, store = true)
    private String otherProjectStr = "";//立项的信息，因为立项信息特别多，只显示前面8条
    @Field(type = FieldType.Integer)
    private Integer otherProjectNum = 0;//立项的数量
    @Field(type = FieldType.Text,analyzer = "comma")
    private String oldName = "";//曾用名


    //经营范围
    @Field(type = FieldType.Text, store = true)
    private String businessScope;

    //法人名称
    @Field(type = FieldType.Keyword)
    private String legalUser;

    //技术领域1
    @Field(type = FieldType.Keyword)
    private Long productTeachField1;
    /**
     * 所属行业1
     */
    @Field(type = FieldType.Long)
    private Long industryField1;
    /**
     * 产业领域1
     */
    @Field(type = FieldType.Keyword)
    private Long domainField1;

    //自定义标签
    @Field(type = FieldType.Text, analyzer = "comma")
    private String featureTags;

    //企业人员规模
    @Field(type = FieldType.Integer)
    private Integer enterpriseScale;

    //入库方式
    @Field(type = FieldType.Keyword)
    private String dataSourceType;

    //电话
    @Field(type = FieldType.Keyword)
    private String legalPhone;

    //更多电话
    @Field(type = FieldType.Keyword)
    private String mobilePhoneMore;

    //邮箱
    @Field(type = FieldType.Keyword)
    private String legalEmail;

    //更多邮箱
    @Field(type = FieldType.Keyword)
    private String emailMore;

    //纳税识别号
    @Field(type = FieldType.Keyword)
    private String taxCode;

    //组织机构代码
    @Field(type = FieldType.Keyword)
    private String organizationCode;

    //参保人数
    @Field(type = FieldType.Integer)
    private Integer insureNum;

    //注册号
    @Field(type = FieldType.Keyword)
    private String registerCode;

    //经营转态
    @Field(type = FieldType.Keyword)
    private String operateState;

    //高企类型 0 可培育， 1，待培育， 2，存量高企
    @Field(type = FieldType.Keyword)
    private Integer highlyEnterpriseType = 1;
    /**
     * 技术领域2
     */
    @Field(type = FieldType.Long)
    private Long productTeachField2;
    /**
     * 技术领域2
     */
    @Field(type = FieldType.Long)
    private Long productTeachField3;
    /**
     * 产业领域2
     */
    @Field(type = FieldType.Long)
    private Long domainField2;
    /**
     * 产业领域3
     */
    @Field(type = FieldType.Long)
    private Long domainField3;
    /**
     * 所属行业2
     */
    @Field(type = FieldType.Long)
    private Long industryField2;
    /**
     * 所属行业3
     */
    @Field(type = FieldType.Long)
    private Long industryField3;

    @Field(type = FieldType.Text, analyzer = "comma", fielddata = true)
    private String hats;

    @Field(type = FieldType.Integer)
    private Integer hasDevelopCoor = 0;//研发机构标识

    @Field(type = FieldType.Integer)
    private Integer isBreedEnterpriseFlag = 0;//设置培育企业的标识

    @Field(type = FieldType.Integer)
    private Integer isProvinceOwnEnterpriseFlag = 0;//设置省民营标识

    @Field(type = FieldType.Text, analyzer = "comma", fielddata = true)
    private String parkId;// 关联的园区ID

    /**
     * 是否上市 0 否 1是
     */
    @Field(type = FieldType.Integer)
    private Integer listFlag = 0;

    /**
     * 是否明星企业
     */
    @Field(type = FieldType.Integer)
    private Integer starFlag = 0;

    /**
     * 是否重点人才
     */
    @Field(type = FieldType.Integer)
    private Integer importantTalentFlag = 0;

    /**
     * 是否高企
     */
    @Field(type = FieldType.Integer)
    private Integer gaoqiFlag = 0;

    /**
     * 是否规上企业
     */
    @Field(type = FieldType.Integer)
    private Integer guishangFlag = 0;

    /**
     * 软著数量
     */
    @Field(type = FieldType.Integer)
    private Integer softwareNum = 0;

    /**
     * 企业所在产业链节点  (ps:這里面的值 必定不能重複)
     */
    @Field(type = FieldType.Text, analyzer = "comma",fielddata = true)
    private String domainLinks;

    /**
     * 省市区中文全称
     */
    @Field(type = FieldType.Text)
    private String regionStr;

    /**
     * 创新分数
     */
    @Field(type = FieldType.Double)
    private Double creativeScore=0.0;

    /**
     * 博士人数
     */
    @Field(type = FieldType.Integer)
    private Integer aBoshi=0;

    /**
     * 硕士人数
     */
    @Field(type = FieldType.Integer)
    private Integer aShuoshi=0;

    /**
     * 本科学历人数
     */
    @Field(type = FieldType.Integer)
    private Integer aBenke=0;

    /**
     * 大专学历人数
     */
    @Field(type = FieldType.Integer)
    private Integer aDaZhuan=0;

    /**
     * 高职职称人数
     */
    @Field(type = FieldType.Integer)
    private Integer gaoJi=0;

    /**
     * 中职职称人数
     */
    @Field(type = FieldType.Integer)
    private Integer allTitleIntermediate=0;

    /**
     * 初级职称人数
     */
    @Field(type = FieldType.Integer)
    private Integer chuJi=0;

    /**
     * 近三年销售收入（万）
     */
    @Field(type = FieldType.Text)
    private String salesRevenue;

    /**
     * 近三年净资产（万）
     */
    @Field(type = FieldType.Text)
    private String netAssets;

    /**
     * 融资次数
     */
    @Field(type = FieldType.Double)
    private Integer financeNum=0;

    /**
     * 融资明细
     */
    @Field(type = FieldType.Text)
    private String financeDetails;

    /**
     * 企业主营产品
     */
    @Field(type = FieldType.Text)
    private String mainProducts;

    /**
     * 研发人员数
     */
    @Field(type = FieldType.Integer)
    private Integer researchNum = 0;

    /**
     * 研发人员占比
     */
    @Field(type = FieldType.Double)
    private Double researchNumPer = 0.0;

    /**
     * 一类知识产权
     */
    @Field(type = FieldType.Integer)
    private Integer intellectualPropertyNum1=0;  // 授权发明

    /**
     * 二类知识产权
     */
    @Field(type = FieldType.Integer)
    private Integer intellectualPropertyNum2=0; // 授权外观、授权实用、软著

    /**
     * 高新技术企业认定证书编号
     */
    @Field(type = FieldType.Keyword)
    private String identifyNumber;

    /**
     * 高新技术企业认定时间
     */
    @Field(type = FieldType.Integer)
    private Integer identifyYear;

    /**
     * 去年企业立项明细
     */
    @Field(type = FieldType.Text)
    private String lastYearOtherProjectStr;

    /**
     * 当年企业立项明细
     */
    @Field(type = FieldType.Text)
    private String currentYearOtherProjectStr;

    /**
     * 去年获得的知识产权数(件)
     */
    @Field(type = FieldType.Integer)
    private Integer lastYearIntellectualNum;

    /**
     * 当年获得的知识产权数(件)
     */
    @Field(type = FieldType.Integer)
    private Integer currentYearIntellectualNum;

    /**
     * 去年获得的授权发明专利
     */
    @Field(type = FieldType.Integer)
    private Integer lastYearGrantedInventNum;

    /**
     * 去年获得的申请发明专利
     */
    @Field(type = FieldType.Integer)
    private Integer lastYearAcceptancedInventNum;

    /**
     * 当年获得的授权发明专利
     */
    @Field(type = FieldType.Integer)
    private Integer currentYearGrantedInventNum;

    /**
     * 当年获得的申请发明专利
     */
    @Field(type = FieldType.Integer)
    private Integer currentYearAcceptancedInventNum;

    /**
     * 去年获得授权实用新型
     */
    @Field(type = FieldType.Integer)
    private Integer lastYearGrantUtilityModelNum;

    /**
     * 去年获得申请实用新型
     */
    @Field(type = FieldType.Integer)
    private Integer lastYearApplyUtilityModelNum;

    /**
     * 当年获得授权实用新型
     */
    @Field(type = FieldType.Integer)
    private Integer currentYearGrantUtilityModelNum;

    /**
     * 当年获得申请实用新型
     */
    @Field(type = FieldType.Integer)
    private Integer currentYearApplyUtilityModelNum;

    /**
     * 去年获得授权外观设计
     */
    @Field(type = FieldType.Integer)
    private Integer lastYearGrantedAppearanceNum;

    /**
     * 去年获得申请外观设计
     */
    @Field(type = FieldType.Integer)
    private Integer lastYearApplyAppearanceNum;

    /**
     * 当年获得授权外观设计
     */
    @Field(type = FieldType.Integer)
    private Integer currentYearGrantedAppearanceNum;

    /**
     * 当年获得申请外观设计
     */
    @Field(type = FieldType.Integer)
    private Integer currentYearApplyAppearanceNum;

    /**
     * 去年获得软件著作权
     */
    @Field(type = FieldType.Integer)
    private Integer lastYearSoftwareNum;

    /**
     * 当年获得软件著作权
     */
    @Field(type = FieldType.Integer)
    private Integer currentYearSoftwareNum;

    /**
     * 去年立项总数
     */
    @Field(type = FieldType.Integer)
    private Integer lastYearOtherProjectNum;

    /**
     * 当年年立项总数
     */
    @Field(type = FieldType.Integer)
    private Integer currentYearOtherProjectNum;

    /**
     * 企业上市类型
     */
    @Field(type = FieldType.Keyword)
    private String marketType;

    /**
     * 企业上市代码
     */
    @Field(type = FieldType.Keyword)
    private String marketNo;

    /**
     * 企业上市时间
     */
    @Field(type = FieldType.Keyword)
    private String marketTime;

    /**
     * 近三年研发投入情况(万元)
     */
    @Field(type = FieldType.Text)
    private String researchInvestment;

    /**
     * 去年一类知识产权
     */
    @Field(type = FieldType.Integer) // 授权发明
    private Integer lastYearIntellectualPropertyNum1;

    /**
     * 去年二类知识产权
     */
    @Field(type = FieldType.Integer)
    private Integer lastYearIntellectualPropertyNum2; // 授权外观、授权实用、软著

    /**
     * 当年一类知识产权
     */
    @Field(type = FieldType.Integer) // 授权发明
    private Integer currentYearIntellectualPropertyNum1;

    /**
     * 当年二类知识产权
     */
    @Field(type = FieldType.Integer)
    private Integer currentYearIntellectualPropertyNum2; // 授权外观、授权实用、软著


    /**
     * 职工总数
     */
    @Field(type = FieldType.Integer)
    private Integer employeesNum;

    /**
     * 企业是否更名
     * 0否，1是
     */
    @Field(type = FieldType.Integer)
    private Integer hasOldName;

    /**
     * 企业是否上市
     * 0否，1是
     */
    @Field(type = FieldType.Integer)
    private Integer hasMarket;

    /**
     *  断档高企， 高企一般是三年有效期，如果超过了三年之后没有认定，则设置为断档高企。
     *      0 不是断档高企， 1，是断档高企
     */
    @Field(type = FieldType.Keyword)
    private Integer expireHighlyEnterprise = 0;

    /**
     * 项目计划
     */
    @Field(type = FieldType.Text)
    private String projectPlan;

    /**
     * 立项年份，包含多个，格式： 帽子id+年份字符串， 例如，帽子id： 109，年份2020， 则 1092020，
     * 如果只要帽子id，但是没有相关年份信息，则使用负数(-帽子id)表示，例如，-109
     */
    @Field(type = FieldType.Text, analyzer = "comma", fielddata = true)
    private String projectApprovalYear;

    /**
     * 是否科技型中小企业
     */
    @Field(type = FieldType.Integer)
    private Integer techMsFlag = 0;

    /**
     *  是否有立项
     */
    @Field(type = FieldType.Integer)
    private Integer approvalProjectFlag;

    /**
     *  是否有研发费用
     */
    @Field(type = FieldType.Integer)
    private Integer researchFeeFlag;

    /**
     *  是否加计扣除
     */
    @Field(type = FieldType.Integer)
    private Integer jjkcFlag;

    @Field(type = FieldType.Integer)
    private Integer evaluatedFlag;
}
