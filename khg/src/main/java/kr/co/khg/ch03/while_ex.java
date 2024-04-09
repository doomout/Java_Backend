package kr.co.khg.ch03;

public class while_ex {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int i = 0;

        while (i < array.length) {
            System.out.println("i = "+ array[i]);
            i++;
        }
    }
}
