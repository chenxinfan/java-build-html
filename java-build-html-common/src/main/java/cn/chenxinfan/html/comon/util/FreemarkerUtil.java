package cn.chenxinfan.html.comon.util;

import cn.chenxinfan.html.comon.constant.CxfConstant;
import cn.chenxinfan.html.comon.domain.FreemarkerModel;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * freemarker操作工具类
 *
 * @author chenxinfan
 * @site www.chenxinfan.cn
 * @date 2023/12/20 21:31
 */
public class FreemarkerUtil {

    /**
     * 使用模板生成HTML代码
     *
     * @param freemarkerModel
     */
    public static void createHtmlFromModel(FreemarkerModel freemarkerModel) {
        FileWriter out = null;
        try {
            // 通过FreeMarker的Confuguration读取相应的模板文件
            Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
            // 设置模板路径
            //todo 常量
            configuration.setClassForTemplateLoading(freemarkerModel.getClazz(), "/ftl");
            // 设置默认字体
            configuration.setDefaultEncoding(CxfConstant.freemarker_encode);
            // 获取模板
            Template template = configuration.getTemplate(freemarkerModel.getTemplateName());
            //设置输出文件
            File file = new File(freemarkerModel.getAbsoluteTargetFileName());
            if (!file.exists()) {
                file.createNewFile();
            }
            //设置输出流
            out = new FileWriter(file);
            //模板输出静态文件
            template.process(freemarkerModel.getDataMap(), out);
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
