package dev.folomkin;

import java.util.Arrays;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 6, 4, 23, 87, 1, 12, 1004};
        int index = 4;
        System.out.println(getElementFromIndex(arr, index));
    }

    static int getElementFromIndex(int[] arr, int index) {
        Optional<Integer> el = Optional.of(
                Arrays.stream(arr)
                        .filter(i -> i == index)
                        .findFirst()
                        .getAsInt()
        );
        return el.orElse(-1);
    }
}

