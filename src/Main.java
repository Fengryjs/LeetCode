import java.sql.Timestamp;
import java.util.ArrayDeque;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Timestamp timestamp = new Timestamp(1727143489000L);
        Date date = new Date(timestamp.getTime());
        System.out.println(date);
    }

    /**
     * 第一行输入一个整数T，表示数据组数。
     * 随后T行，每行开头一个整数n，表示单词A和B的长度，随后两个仅有小写字母组成的单词A，B。
     * 如果A的字典序大于B，输出0。
     * 对于的数据有
     * 对于的数据有
     * @param args
     */
    public static void test(String[] args) {

        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String str = in.next();
        long result = 0;
        HashMap<Character, Long> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            long num = map.getOrDefault(str.charAt(i), 0L);
            map.put(str.charAt(i), num + 1);
        }
        for (long num: map.values()) {
            result += num * (num + 1) / 2;
        }
        System.out.println(result);


    }

    //子串的定义：从字符串中拿出连续的一段，即为子串。例如 bc 是 abc 的子串，但是 ac 不是，因为 ac 在 abc 中不连续。
    //
    //回文串的定义：正着读和反着读一样的字符串为回文串。例如 noon，bb 等，单个字符也是回文串。
    //
    //回文子串的定义：是原字符串的一个子串，且是回文串。
    //
    //给出一个字符串，你可以任意排列里面的字符，使得其回文子串的数量尽可能的多，求回文子串数量最多为多少。

    public static void dictionary() {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int time = in.nextInt();
        for (int i = 0; i < time; i++) {
            int length = in.nextInt();
            String a = in.next();
            String b = in.next();
            long result = StringToLong(b) - StringToLong(a);
            if (result < 0L)
                System.out.println(0);
            else
                System.out.println(result-1);
        }
    }

    public static long StringToLong(String str) {
        long result = 0;
        long index = 1;
        for (int i = str.length() - 1; i >= 0; i--) {
            result += (str.charAt(i) - 'a') * index;
            index = index * 26;
        }
        return result;
    }
}