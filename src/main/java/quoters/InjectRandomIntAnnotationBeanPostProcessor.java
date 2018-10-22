package quoters;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Random;

public class InjectRandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization method for bean " + beanName);
        Field[] declaredFields = bean.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
            if (annotation != null) {
                int min = annotation.min();
                int max = annotation.max();
                int repeat = min + new Random().nextInt(max - min);
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, repeat);
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println("postProcessAfterInitialization");
//        Field[] declaredFields = bean.getClass().getDeclaredFields();
//        for (Field field : declaredFields) {
//            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
//            if (annotation != null) {
//                int min = annotation.min();
//                int max = annotation.max();
//                int repeat = min + new Random().nextInt(max - min);
//                field.setAccessible(true);
//                ReflectionUtils.setField(field, bean, repeat);
//            }
//        }
        return bean;
    }
}
