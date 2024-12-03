package study.cglib;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.ClassCastException;

public class DynamicProxy {
    final static Sample sample = new Sample();
    public static void main(String[] args) {
        SampleService object = (SampleService) Proxy.newProxyInstance(Sample.class.getClassLoader(), SampleServiceImpl.class.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return method.invoke(sample, args);
            }
        });
        for (Class<?> i : SampleServiceImpl.class.getInterfaces()){
            System.out.println(i.getName());
        }
//        object.send("1");
    }
}
