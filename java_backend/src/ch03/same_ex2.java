package ch03;

public class same_ex2 {
    public static void main(String[] args) {
        String str1 = new String("is same?");
        String str2 = new String("is same?");

        System.out.println(str1.equals(str2)); // true or false?
    }
}

/**실행결과
 true
 객체간에 같은지 비교하려면 == 이 아닌 equals()로 비교해야 한다.
 */