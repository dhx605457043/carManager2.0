package com.car.manager.util;

import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: JiangJunCheng
 * @Date: 2020/4/23 11:36
 * @Description:
 **/
public class BeanCopyUtils {

    public static <T> T copyBean(Object source, T target) {

        BeanCopier beanCopier = BeanCopier.create(source.getClass(), target.getClass(), false);

        beanCopier.copy(source, target, null);
        return target;
    }

    public static List<?> copyBeanList(List<?> sourceList, Class target) {

        List<Object> result = new ArrayList();
        if (sourceList != null) {
            for (Object source : sourceList) {

                try {
                    Object o = target.newInstance();
                    result.add(copyBean(source, o));
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
        }
        return result;
    }
}
