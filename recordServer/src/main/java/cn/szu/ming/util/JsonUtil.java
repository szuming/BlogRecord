package cn.szu.ming.util;

import cn.szu.ming.entity.Record;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;

//json序列化工具
public class JsonUtil {
    private static ObjectMapper objectMapper=new ObjectMapper();

    //序列化
    public static String serializer(Object object) throws IOException {
        StringWriter sw=new StringWriter();
        JsonGenerator jsonGenerator=new JsonFactory().createGenerator(sw);
        objectMapper.writeValue(jsonGenerator,object);
        jsonGenerator.close();
        return sw.toString();
    }

    //反序列化
    public static <T> T deserializer(String objectJson, Class<T> objClass) throws IOException {
        return objectMapper.readValue(objectJson,objClass);
    }
}
