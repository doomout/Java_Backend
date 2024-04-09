package kr.co.khg.ch03;

import java.util.Arrays;
import java.util.List;

public class map_ex {
    public static void main(String[] args) {
        String[] lowercaseArray = new String[]{"public", "static", "void"};
        List<String> lowercaseList = Arrays.asList(lowercaseArray);
        //전체를 대문자로 변환
        List<String> uppercaseList = lowercaseList.stream().map(value -> value.toUpperCase()).toList();
        uppercaseList.stream().forEach(value -> System.out.println(value));
    }
}

/**실행결과
PUBLIC
STATIC
VOID 
 */