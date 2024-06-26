package kr.co.khg.ch03;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class lambda_ex {
    public static void main(String[] args) {
        List list = new ArrayList<String>();

        list.add("public");
        list.add("static");
        list.add("void");

        // 익명 클래스 코드
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                return str1.compareTo(str2);
            }
        });

        // 람다 표현식 코드
        list.sort((Comparator<String>) (str1, str2) -> str1.compareTo(str2));

        System.out.println(list);
    } 
}

/**실행결과
 [public, static, void]
 */