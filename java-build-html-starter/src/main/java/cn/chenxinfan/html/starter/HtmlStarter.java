package cn.chenxinfan.html.starter;

import cn.chenxinfan.html.comon.domain.FreemarkerModel;
import cn.chenxinfan.html.comon.util.FreemarkerUtil;

/**
 * html静态页面starter
 *
 * @author chenxinfan
 * @site www.chenxinfan.cn
 * @date 2023/12/19 22:22
 */
public class HtmlStarter {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        FreemarkerModel freemarkerModel = new FreemarkerModel();
        freemarkerModel.setClazz(HtmlStarter.class);
        freemarkerModel.setTemplateName("index.ftl");
        String path = HtmlStarter.class.getClassLoader().getResource("").getPath().replaceAll("%20", " ");
        freemarkerModel.setAbsoluteTargetFileName(path + "index.html");
        FreemarkerUtil.createHtmlFromModel(freemarkerModel);

        long end = System.currentTimeMillis();
        System.out.println("handle complete time = " + (end - start) + "毫秒.");
    }

}
