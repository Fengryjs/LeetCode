package study.tryCatchFinall;

public class Try {
    public static void main(String[] args) {
        System.out.println(f(2));
    }

    public static int f(int value) {
        try {
            return value + 1;
        } finally {
            if (value == 2) {
                return 0;
            }
        }
    }
}
