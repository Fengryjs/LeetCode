package _1114;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.StampedLock;
public class Foo {

    AtomicBoolean first;
    AtomicBoolean second;
    public Foo() {
        first = new AtomicBoolean(false);
        second = new AtomicBoolean(false);
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.

        printFirst.run();
        first.set(true);
    }

    public void second(Runnable printSecond) throws InterruptedException {

        while (!first.get())
            continue;
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        second.set(true);

    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        while (!second.get())
            continue;
        printThird.run();
    }
}
