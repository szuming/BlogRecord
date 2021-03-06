package cn.szu.ming.util;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.HashMap;
import java.util.Map;

public class MyPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
    Map<String,String> map=new HashMap<>();

    public MyPropertyPlaceholderConfigurer(){
        map.put("username","ming");
        map.put("password","qq147741");
        map.put("url","jdbc:mysql://127.0.0.1:3306/BlogRecord");
    }
    @Override
    protected String convertProperty(String propertyName, String propertyValue) {
        String temp=map.get(propertyName);
        if(temp!=null){
            return temp;
        }
        return super.convertProperty(propertyValue,propertyValue);
    }
}

