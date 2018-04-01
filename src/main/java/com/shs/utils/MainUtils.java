package com.shs.utils;

import com.shs.entity.Item;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Map;

public class MainUtils {

    /**
     * Invoking methods of classes that extends Item with attributes
     * from servlet.request.getParameters
     * Can use Commons BeanUtils instead this.
     *
     * @author Serg Shankunas
     */


    public static void setItemAttributes(Item item, Map<String, String[]> attributes) {
        for (Map.Entry<String, String[]> entry : attributes.entrySet()) {
            Field field = ReflectionUtils.findField(Item.class, entry.getKey());
            if (field != null) {
                ReflectionUtils.makeAccessible(field);
                ReflectionUtils.setField(field, item, entry.getValue()[0]);
            }
        }
    }
}
