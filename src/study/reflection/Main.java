package study.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class<?> myClass = Class.forName("study.reflection.MyClass");
        MyClass c = (MyClass) myClass.newInstance();
        c.getClass().getMethods();
        Method[] methods = c.getClass().getDeclaredMethods();
        Field[] fields = c.getClass().getDeclaredFields();
        for (Method method : methods) {
            System.out.println(method.getName());
            method.setAccessible(true);
            method.invoke(c);
        }

    }
}
