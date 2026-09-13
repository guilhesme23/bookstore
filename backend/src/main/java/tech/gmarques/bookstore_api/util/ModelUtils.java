package tech.gmarques.bookstore_api.util;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.Arrays;

public class ModelUtils {
    public static String[] getNullProperties(Object source) {
        BeanWrapper wrap = new BeanWrapperImpl(source);

        return Arrays.stream(wrap.getPropertyDescriptors())
                .map(PropertyDescriptor::getName)
                .filter(name -> wrap.getPropertyValue(name) == null)
                .toArray(String[]::new);
    }
}
