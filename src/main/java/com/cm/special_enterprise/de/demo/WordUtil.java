package com.cm.special_enterprise.de.demo;
import freemarker.template.Configuration;
import freemarker.template.Template;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Map;

public class WordUtil {
    //配置信息
    public static Configuration configuration = null;
    //这里注意的是利用WordUtils的类加载器动态获得模板文件的位置
    private static String templateFolder;
    //模板文件，可以方便修改
    private static String fileInName;
    public WordUtil() {

    }
    public WordUtil(String fileInName){
        WordUtil.fileInName=fileInName;

        // templateFolder = WordUtil.class.getClassLoader().getResource("…/…/")+“META-INF/libs”;
        // templateFolder = templateFolder.replaceAll("%20", " ");
        configuration = new Configuration();
        configuration.setDefaultEncoding("utf-8");
        try {
        // configuration.setDirectoryForTemplateLoading(new File(templateFolder.substring(5)));
            configuration.setClassForTemplateLoading(this.getClass(), "com/cm/special_enterprise/resources/templates");
            configuration.getTemplate(fileInName);
            configuration.setClassicCompatible(true); //解决null空值的问题
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void exportMillCertificateWord(HttpServletRequest request, HttpServletResponse response, Map map, String fileName) throws IOException {
        Template freemarkerTemplate = configuration.getTemplate(fileInName);
        File file = null;
        InputStream fin = null;
        ServletOutputStream out = null;
        try {
            // 调用工具类的createDoc方法生成Word文档
            file = createDoc(map,freemarkerTemplate);
            fin = new FileInputStream(file);
            response.setContentType("application/msword");
            // 设置浏览器以下载的方式处理该文件名
            fileName +=  ".doc";
            response.setHeader("Content-Disposition", "attachment;filename=".concat(String.valueOf(URLEncoder.encode(fileName, "UTF-8"))));
            response.setCharacterEncoding("utf-8");

            out = response.getOutputStream();
            byte[] buffer = new byte[1024];  // 缓冲区
            int bytesToRead = -1;
            // 通过循环将读入的Word文件的内容输出到浏览器中
            while((bytesToRead = fin.read(buffer)) != -1) {
                out.write(buffer, 0, bytesToRead);
            }
            out.flush();
        } finally {
            if(fin != null) fin.close();
            if(out != null) out.close();
            if(file != null) file.delete(); // 删除临时文件
        }
    }

    public static File createDoc(Map<?, ?> dataMap, Template template) {
        String name =  "test.doc";
        File f = new File(name);
        Template t = template;
        try {
            // 这个地方不能使用FileWriter因为需要指定编码类型否则生成的Word文档会因为有无法识别的编码而无法打开
            Writer w = new OutputStreamWriter(new FileOutputStream(f), "utf-8");
            t.process(dataMap, w);
            w.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return f;
    }
    public static void main(String[] args) {
        String path = cn.hutool.poi.word.WordUtil.class.getClassLoader().getSystemResource("META-INF").getPath();
        System.out.println(path);
    }

}
