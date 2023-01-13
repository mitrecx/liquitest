package com.example.liquibasedemo.test;


import cn.hutool.core.util.StrUtil;
import com.example.liquibasedemo.po.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyTest {
    static Logger logger = LoggerFactory.getLogger(MyTest.class);

    public <T> T generateObject(Class<T> clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        clazz.newInstance();
        return clazz.getDeclaredConstructor().newInstance();
    }

    public static <T> T setNullValue(T source) throws IllegalArgumentException, IllegalAccessException, SecurityException {
        if (source == null) {
            return null;
        }
        Field[] fields = source.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.getGenericType().toString().equals("class java.lang.String")) {
                field.setAccessible(true);
                Object obj = field.get(source);
                if (obj == null) {
                    continue;
                }
                String str = obj.toString();
                field.set(source, StrUtil.trimToNull(str));
            }
        }
        return source;
    }


    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    }
}
