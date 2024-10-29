package dev.folomkin.search;

// Binary search:

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Code {
    public static void main(String[] args) {
        List<Integer> numbersList = new ArrayList<>();
        Collections.sort(numbersList);
        int index = Collections.binarySearch(numbersList, 10);

        System.out.println(index);
    }
}
