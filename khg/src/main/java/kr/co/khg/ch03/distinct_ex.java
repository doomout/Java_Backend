package kr.co.khg.ch03;

import java.util.Arrays;
import java.util.List;

public class distinct_ex {
    public static void main(String[] args) {
        Integer[] integerArray = new Integer[]{1, 1, 1, 1, 2, 2, 2, 3, 3, 4};
        List<Integer> list = Arrays.asList(integerArray);
        List<Integer> distinctList = list.stream().distinct().toList(); //중복제거
        distinctList.stream().forEach(value -> System.out.println(value));
    }
}
/**실행결과
1
2
3
4
 */