package com.cm.special_enterprise.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.*;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import java.util.Date;
import java.util.List;


@Document(indexName = "liaoning_enterprise_index2", createIndex = true, useServerConfiguration = true)

@Data
public class EnterpriseBaseIndex extends BaseMapping {

    /**
     * 企业名,同时支持模糊和精确查询
     */
    @MultiField(mainField = @Field(type = FieldType.Text), otherFields = {
            @InnerField(type = FieldType.Keyword, suffix = "keyword")})
    private String name;

    /**
     * 适配产业项目
     */
    @Field(type = FieldType.Keyword)
    private String domainLinkProject;

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

    //所属国家 字典id
    @Field(type = FieldType.Long)
    private Long countryId;

    //省份id d_full_city
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

    //注册资本浮点型数据
    @Field(type = FieldType.Double)
    private Double registerMoneyByDouble;

    //企业收入规模
    @Field(type = FieldType.Long)
    private Long enterpriseIncomeScale;

    //注册类型 字典id
    @Field(type = FieldType.Long)
    private Long registerType;

    @Field(type = FieldType.Integer)
    private Integer grantedInventNum = 0; //授权发明数
    @Field(type = FieldType.Integer)
    private Integer acceptancedInventNum = 0;//受理,申请发明数
    @Field(type = FieldType.Integer)
    private Integer grantUtilityModelNum = 0; //授权实用新型数
    @Field(type = FieldType.Integer)
    private Integer applyUtilityModelNum = 0; // 申请实用新型数

    /**
     * 软著数量
     */
    @Field(type = FieldType.Integer)
    private Integer softwareNum = 0;


    @Field(type = FieldType.Integer)
    private Integer appearance = 0; //外观专利数

    @Field(type = FieldType.Integer)
    private Integer grantedAppearanceNum = 0; // 授权外观数
    @Field(type = FieldType.Integer)
    private Integer applyAppearanceNum = 0; // 申请外观数

    @Field(type = FieldType.Integer)
    private Integer intellectualNum = 0;//知产总量

    /**
     * 立项数量
     */
    @Field(type = FieldType.Integer)
    private Integer otherProjectNum = 0;//立项的数量

    @Field(type = FieldType.Keyword, store = true)
    private String otherProjectStr = "";//立项的信息，因为立项信息特别多，只显示前面8条

    @Field(type = FieldType.Text, analyzer = "comma")
    private String oldName = "";//曾用名

    //经营范围
    @Field(type = FieldType.Text, store = true)
    private String businessScope;

    //法人名称
    @Field(type = FieldType.Keyword)
    private String legalUser;

    //技术领域1 d_required_field
    @Field(type = FieldType.Long)
    private Long productTeachField1;
    /**
     * 所属行业1 d_standard_industry
     */
    @Field(type = FieldType.Long)
    private Long industryField1;
    /**
     * 产业领域1 d_domain_field
     */
    @Field(type = FieldType.Keyword)
    private Long domainField1;

    //自定义标签
    @Field(type = FieldType.Text, analyzer = "comma")
    private String featureTags;

    //企业人员规模
    @Field(type = FieldType.Long)
    private Long enterpriseScale;

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
    @Field(type = FieldType.Keyword)
    private String insureNum;

    //注册号
    @Field(type = FieldType.Keyword)
    private String registerCode;

    //经营转态
    @Field(type = FieldType.Keyword)
    private String operateState;

    //     * 高企类型 -1 全部 0  可培育高企，1待培育高企业  ，2 存量高企
    @Field(type = FieldType.Keyword)
    private Integer highlyEnterpriseType = 1;

    /**
     * 断档高企， 高企一般是三年有效期，如果超过了三年之后没有认定，则设置为断档高企。
     * 0 不是断档高企， 1，是断档高企
     */
    @Field(type = FieldType.Keyword)
    private Integer expireHighlyEnterprise = 0;

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

    /**
     * 帽子id d_hats
     */
    @Field(type = FieldType.Text, analyzer = "comma", fielddata = true)
    private String hats;

    @Field(type = FieldType.Integer)
    private Integer hasDevelopCoor = 0;//研发机构标识

    @Field(type = FieldType.Integer)
    private Integer isProvinceOwnEnterpriseFlag = 0;//设置省民营标识

    @Field(type = FieldType.Text, analyzer = "comma")
    private String parkId;// 关联的园区ID

    /**
     * 是否上市
     */
    @Field(type = FieldType.Integer)
    private Integer listFlag;

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
     * 是否规上企业
     */
    @Field(type = FieldType.Integer)
    private Integer guishangFlag = 0;

    /**
     * 是否高企
     */
    @Field(type = FieldType.Integer)
    private Integer gaoxinFlag = 0;

    /**
     * 企业所在产业链节点  (ps:這里面的值 必定不能重複)
     */
    @Field(type = FieldType.Text, analyzer = "comma", fielddata = true)
    private String domainLinks;

    /**
     * 产业链分数
     */
    @Field(type = FieldType.Nested)
    private List<DomainLinkScore> domainLinkScores;

    /**
     * 国信给的创新分数
     */
    @Field(type = FieldType.Double)
    private Double creativeScore = 0.0;

    /**
     * 博士人数
     */
    @Field(type = FieldType.Integer)
    private Integer aBoshi = 0;

    /**
     * 硕士人数
     */
    @Field(type = FieldType.Integer)
    private Integer aShuoshi = 0;

    /**
     * 本科学历人数
     */
    @Field(type = FieldType.Integer)
    private Integer aBenke = 0;

    /**
     * 大专学历人数
     */
    @Field(type = FieldType.Integer)
    private Integer aDaZhuan = 0;

    /**
     * 高职职称人数
     */
    @Field(type = FieldType.Integer)
    private Integer gaoJi = 0;

    /**
     * 中职职称人数
     */
    @Field(type = FieldType.Integer)
    private Integer allTitleIntermediate = 0;

    /**
     * 初级职称人数
     */
    @Field(type = FieldType.Integer)
    private Integer chuJi = 0;

    /**
     * 近三年销售收入（万）
     */
    @Field(type = FieldType.Keyword)
    private String salesRevenue;

    /**
     * 近三年净资产（万）
     */
    @Field(type = FieldType.Keyword)
    private String netAssets;

    /**
     * 融资次数
     */
    @Field(type = FieldType.Integer)
    private Integer financeNum = 0;

    /**
     * 融资明细
     */
    @Field(type = FieldType.Keyword)
    private String financeDetails;

    /**
     * 企业主营产品
     */
    @Field(type = FieldType.Keyword)
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
    private Integer intellectualPropertyNum1 = 0;  // 授权发明

    /**
     * 二类知识产权
     */
    @Field(type = FieldType.Integer)
    private Integer intellectualPropertyNum2 = 0; // 授权外观、授权实用、软著

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
     * 去年企业立项明细
     */
    @Field(type = FieldType.Keyword)
    private String lastYearOtherProjectStr;

    /**
     * 当年企业立项明细
     */
    @Field(type = FieldType.Keyword)
    private String currentYearOtherProjectStr;

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
    @Field(type = FieldType.Keyword)
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
     * 省字典
     */
    @Field(type = FieldType.Keyword)
    private String provinceCode;
    /**
     * 市
     */
    @Field(type = FieldType.Keyword)
    private String cityCode;
    /**
     * 区
     */
    @Field(type = FieldType.Keyword)
    private String areaCode;

    /**
     * "研"值模型分数
     */
    @Field(type = FieldType.Double)
    private Double ResearchScore;


    @Field(type = FieldType.Integer)
    private Integer sortNum;

    @Field(type = FieldType.Text, analyzer = "comma")
    private String projectTags;// 产品标签

    /**
     * 产业链分数
     */
    @Data
    public static class DomainLinkScore {
        @Field(type = FieldType.Long)
        private Long domainLinkId;

        @Field(type = FieldType.Double)
        private Double finalScore;
    }

}
