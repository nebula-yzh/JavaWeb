package utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

public class WebUtils {
    //通过一行代码将所有请求参数 注入到user对象中，使用beanutils工具包，第三方导入

    /**
     * 把map中的值 注入到JavaBean属性中
     *
     * @param value
     * @param bean
     * @return 一个javabean对象
     */
    //写成泛型
    public static <T> T copyParamToBean(Map value, T bean) {
        try {
            //把所有参数注入bean对象中
            BeanUtils.populate(bean, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * 将字符串转换成int类型数据
     * @param strInt
     * @param defaultValue
     * @return
     */
    public static int parseInt(String strInt, int defaultValue) {
        try {
            return Integer.parseInt(strInt);
        } catch (Exception e) {
           // e.printStackTrace();
        }
        return defaultValue;
    }
}
