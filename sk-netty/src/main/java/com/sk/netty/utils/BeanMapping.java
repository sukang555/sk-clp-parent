package com.sk.netty.utils;

import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 基于cglib的bean属性拷贝，只支持同名同类型的字段拷贝
 * @author zcli
 */
public class BeanMapping {
    private static final Map<String, BeanCopier> beanCopierCache = new ConcurrentHashMap<>();

    private static String generateKey(Class<?> class1, Class<?> class2) {
        return class1.getName() + class2.getName();
    }

    private static BeanCopier getBeanCopier(Class<?> sourceClass, Class<?> targetClass) {
        String beanKey = generateKey(sourceClass, targetClass);
        BeanCopier copier = null;
        try {
            if (!beanCopierCache.containsKey(beanKey)) {
                copier = BeanCopier.create(sourceClass, targetClass, false);
                beanCopierCache.put(beanKey, copier);
            } else {
                copier = beanCopierCache.get(beanKey);
            }
        } catch (Exception ex) {
            throw new IllegalArgumentException("Bean copy error ", ex);
        }

        return copier;
    }

    private static <S, D> D copyOne(BeanCopier copier, S source, Class<D> targetClass, Converter<S, D> biConsumer) {
        try {
            D distObj = targetClass.newInstance();
            copier.copy(source, distObj, null);

            // 特殊需要处理的字段
            if(distObj != null && biConsumer != null) {
                biConsumer.convert(source, distObj);
            }
            return distObj;
        } catch (Exception e) {
            throw new IllegalArgumentException("Bean copy error ", e);
        }
    }

    /**
     * 将原对象的属性拷贝到目标对象中,不生成新的对象
     * @param source 原对象
     * @param target 目标对象
     * @param <S> 原数据类型
     * @param <D> 目标数据类型
     */
    public static <S, D> void copy(S source, D target) {
        BeanCopier copier = getBeanCopier(source.getClass(), target.getClass());
        try {
            copier.copy(source, target, null);
        } catch (Exception ex) {
            throw new IllegalArgumentException("Bean copy error ", ex);
        }
    }

    /**
     * 将原对象的属性拷贝到目标对象中
     * @param source 原对象
     * @param targetClass 目标类型
     * @param <S> 原数据类型
     * @param <D> 目标数据类型
     * @return 返回目标对象
     */
    public static <S, D> D copy(S source, Class<D> targetClass) {
        return copy(source, targetClass, null);
    }

    /**
     * 将原对象的属性拷贝到目标对象中，允许对特定字段单独处理
     * @param source 原对象
     * @param targetClass 目标类型
     * @param converter 自定义转换器
     * @param <S> 原数据类型
     * @param <D> 目标数据类型
     * @return 返回目标对象
     */
    public static <S, D> D copy(S source, Class<D> targetClass, Converter<S, D> converter) {
        BeanCopier copier = getBeanCopier(source.getClass(), targetClass);
        return copyOne(copier, source, targetClass, converter);
    }

    /**
     * 批量将原对象的属性拷贝到目标对象中
     * @param sourceList 原对象集合
     * @param targetClass 目标类型
     * @param <S> 原数据类型
     * @param <D> 目标数据类型
     * @return 返回目标对象集合
     */
    public static <S, D> List<D> copyList(List<S> sourceList, Class<D> targetClass) {
        return copyList(sourceList, targetClass, null);
    }

    /**
     * 批量将原对象的属性拷贝到目标对象中，允许对特定字段单独处理
     * @param sourceList 原对象集合
     * @param targetClass 目标类型
     * @param converter 自定义转换器
     * @param <S> 原数据类型
     * @param <D> 目标数据类型
     * @return 返回目标对象集合
     */
    public static <S, D> List<D> copyList(List<S> sourceList, Class<D> targetClass, Converter<S, D> converter) {
        if (sourceList == null || sourceList.isEmpty()) {
            return new ArrayList<>();
        }
        List<D> resultList = new ArrayList<>(sourceList.size());
        Class<?> sourceClass = sourceList.get(0).getClass();
        BeanCopier copier = getBeanCopier(sourceClass, targetClass);
        for (S source : sourceList) {
            resultList.add(copyOne(copier, source, targetClass, converter));
        }
        return resultList;
    }

    public interface Converter<S, D> {
        /**
         * 转换
         * @param source
         * @param dist
         */
        void convert(S source, D dist);
    }

}