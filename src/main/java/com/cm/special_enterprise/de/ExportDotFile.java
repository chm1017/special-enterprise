//package com.cm.special_enterprise.de;
//
//import cn.hutool.extra.template.Template;
//import org.mybatis.logging.Logger;
//import org.mybatis.logging.LoggerFactory;
//
//import javax.security.auth.login.Configuration;
//import java.io.*;
//import java.util.Map;
//
//public class ExportDotFile {
//    private static Logger logger = LoggerFactory.getLogger(ExportDotFile.class);
//
//    private static ExportDotFile service = null;
//
//    private ExportDotFile() {
//        super();
//    }
//
//    public static ExportDotFile getInstance() {
//        if (service == null) {
//            service = new ExportDotFile();
//        }
//        return service;
//    }
//
//
//    /**
//     * @param templateFilePath eg: /template/test/test.ftl
//     * @param dataMap
//     * @param exportFilePath   eg: /tmp/test/test123.doc
//     * @param loadType         设置路径加载方式。1-绝对路径，2-项目相对路径
//     * @return
//     * @throws Exception
//     */
//    public File createDocFile(String templateFilePath, Map<String, Object> dataMap, String exportFilePath, int loadType) {
//        Template t = null;
//        Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);
//        configuration.setDefaultEncoding("UTF-8");
//        Writer out = null;
//        FileOutputStream fos = null;
//        OutputStreamWriter oWriter = null;
//        File outFile = new File(exportFilePath);
//        try {
//            templateFilePath = pathReplace(templateFilePath);
//            String ftlPath = templateFilePath.substring(0, templateFilePath.lastIndexOf('/'));
//            if (loadType == 1) {
//                configuration.setDirectoryForTemplateLoading(new File(ftlPath)); // FTL文件所存在的位置
//            } else {
//                configuration.setClassForTemplateLoading(this.getClass(), ftlPath);//以类加载的方式查找模版文件路径
//            }
//
//            String ftlFile = templateFilePath.substring(templateFilePath.lastIndexOf('/') + 1);
//            t = configuration.getTemplate(ftlFile); // 模板文件名
//            fos = new FileOutputStream(outFile);
//            oWriter = new OutputStreamWriter(fos, "UTF-8");
//            out = new BufferedWriter(oWriter);
//
//            t.process(dataMap, out);
//            oWriter.flush();
//            out.flush();
//            oWriter.close();
//        } catch (Exception e) {
//            logger.error("导出word文档出错", e);
//        } finally {
//            try {
//                if (out != null) {
//                    out.close();
//                }
//                if (null != fos) {
//                    fos.close();
//                }
//                if (null != oWriter) {
//                    oWriter.close();
//                }
//            } catch (IOException e) {
//                logger.error("关闭Write对象出错", e);
//            }
//        }
//        return outFile;
//    }
//
//    /**
//     * 把路径的\替换成/
//     *
//     * @param path
//     * @return
//     */
//    private String pathReplace(String path) {
//        while (path != null && path.contains("\\")) {
//            path = path.replace("\\", "/");
//        }
//        return path;
//    }
//}