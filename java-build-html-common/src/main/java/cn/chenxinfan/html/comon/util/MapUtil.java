package cn.chenxinfan.html.comon.util;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenxinfan
 * @site www.chenxinfan.cn
 * @date 2023/12/20 22:07
 */
public class MapUtil {

    /**
     * 将object对象转为Map结构
     *
     * @param data
     * @return
     */
    public static Map convertToMap(Object data) {
        if (data == null) {
            return new HashMap<>();
        }
        //todo data 是否是常用数据类型
        String dataStr = JSONObject.toJSONString(data);
        return JSONObject.parseObject(dataStr, Map.class);
    }
}
