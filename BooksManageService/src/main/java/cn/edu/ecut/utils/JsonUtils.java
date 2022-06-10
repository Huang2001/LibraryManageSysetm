package cn.edu.ecut.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;

/**
 * 2022/6/10 15:13
 *
 * @author chris
 * @version 1.0
 */

public class JsonUtils {
    public static String getJson(Object object){
        return getJson(object,"yyyy-mm-dd HH:mm:ss");
    }

    public static String getJson(Object object,String dateFormat){
        ObjectMapper mapper = new ObjectMapper();
        // 不使用时间戳
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        // 自定义日期格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        mapper.setDateFormat(simpleDateFormat);
        try{
            return mapper.writeValueAsString(object);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return null;
    }
}
