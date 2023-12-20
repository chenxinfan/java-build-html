package cn.chenxinfan.html.comon.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenxinfan
 * @site www.chenxinfan.cn
 * @date 2023/12/20 22:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FreemarkerModel {

    /**
     * 解析类
     */
    private Class<?> clazz;

    /**
     * 模板名称
     */
    private String templateName;

    /**
     * 生成文件的绝对路劲
     */
    private String absoluteTargetFileName;

    /**
     * 模板填充数据
     */
    private Map<Object, Object> dataMap = new HashMap<>();
}
