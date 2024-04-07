package ch03;

public class same_ex {
    public static void main(String[] args) {
        String str1 = new String("is same?");
        String str2 = new String("is same?");

        System.out.println(str1 == str2); // true or false?
    }
}

/**실행 결과 
 false
 자바에서 동일하다고 하는 경우는 같은 인스턴스를 참조 하고 있을 때다.
 해당 예제는 다른 인스턴스를 참조하기에 동일하지 않다.
 */