package study.reflection;

import java.lang.reflect.Method;

public class MyClass {

    public String publicFiled;
    private String privateFiled;

    public String printPublic() {
        System.out.println(publicFiled);
        return publicFiled;
    }

    private String printPrivate() {
        System.out.println(privateFiled);
        return privateFiled;
    }
}
