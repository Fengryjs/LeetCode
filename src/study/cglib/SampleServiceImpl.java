package study.cglib;

public class SampleServiceImpl implements SampleService, TestInterface{

    @Override
    public String send(String msg) {
        System.out.println(msg);
        return msg;
    }
}
