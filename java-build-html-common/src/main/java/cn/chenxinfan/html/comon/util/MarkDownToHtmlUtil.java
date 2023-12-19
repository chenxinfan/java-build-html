package cn.chenxinfan.html.comon.util;

import com.vladsch.flexmark.ext.tables.TablesExtension;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.MutableDataSet;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * markdown转为html
 *
 * @author chenxinfan
 * @site www.chenxinfan.cn
 * @date 2023/12/19 22:31
 */
public class MarkDownToHtmlUtil {

    public static String mdToHtml(String markdown) {
        MutableDataSet options = new MutableDataSet();
        //添加对表格的处理
        options.set(Parser.EXTENSIONS, Arrays.asList(TablesExtension.create()));
        Parser parser = Parser.builder(options).build();
        HtmlRenderer renderer = HtmlRenderer.builder(options).build();
        Node document = parser.parse(markdown);
        return renderer.render(document);
    }

    public static String htmlAppendAttribute(String html, String label, String attribute) {
        StringBuilder sbr = new StringBuilder(html);
        int i = 0;
        while ((i = sbr.indexOf(label, i)) != -1) {
            sbr.insert(i + label.length(), attribute);
            i = i + attribute.length() + 1;
        }
        return sbr.toString();
    }

    public static String handleMarkdownImgSymbol(String markDownStr, String symbol) {
        StringBuilder sbr = new StringBuilder(markDownStr);
        String imgSymbol = "![" + symbol + "]";
        int index = 0;
        while ((index = markDownStr.indexOf(imgSymbol, index)) != -1) {
            index = index + imgSymbol.length();
            int start = markDownStr.indexOf("(", index);
            int end = markDownStr.indexOf(")", index);
            if (end - start <= 1) {
                continue;
            }
            String imgPath = markDownStr.substring(start + 1, end);
            if (StringUtils.isBlank(imgPath)) {
                continue;
            }
            String suffix = imgPath.substring(imgPath.lastIndexOf(".") + 1).toLowerCase();
//            if (!freedomConfig.isCorrectImgSuffix(suffix)) {
//                continue;
//            }
            String imgName = imgPath.substring(Math.max(imgPath.lastIndexOf("\\"), 0) + 1, imgPath.lastIndexOf("."));
//            String newImgPath = freedomConfig.getImgServerSymbol() + "\\" + imgName + "." + suffix;
            String newImgPath = null;
            sbr.replace(start + 1, end, newImgPath);
            markDownStr = sbr.toString();
            index = index + imgSymbol.length();
        }
        return sbr.toString();
    }
}
