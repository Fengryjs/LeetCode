package study.cglib;

public class StaticProxy implements SampleService {
    private final SampleService service;

    public StaticProxy(SampleService service) {
        this.service = service;
    }

    @Override
    public String send(String msg) {
        // Some other action
        System.out.println("other action before");
        service.send(msg);
        System.out.println("other action after");
        return null;
    }
}
