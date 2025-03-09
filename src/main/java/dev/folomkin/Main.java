package dev.folomkin;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] values = {11, 12, 18, 72, 82, 84, 86, 90, 102, 122, 123, 124, 130};
        int valueToFind = 72;

        System.out.printf("Index = %d%n", binarySearch(values, valueToFind));
    }

    private static int binarySearch(int[] sortedArray, int valueToFind) {
        int index = -1;

        //-> 1. Сортируем массив:
        Arrays.sort(sortedArray);   //  int[] values = {11, 12, 18, 72, 82, 84, 86, 90, 102, 122, 123, 124, 130};

        var low = 0; // 0
        var high = sortedArray.length - 1; // 8
        while (low <= high) {

            //-> 2. Делим пополам и находим середину
            var middle = low + (high - low) / 2;
            var current = sortedArray[middle]; //-> current - текущий элемент

            // 3. Сравниваем средний элемент с искомым:

            // 4. Если искомое больше среднего - продолжаем
            // поиск в правой части массива: делим ее пополам, повторяя пункт 3.
            // Если заданное число меньше - возвращаемся к пункту 3.

            if (valueToFind > current) {
                // текущий элемент меньше искомого - сдвигаем левую границу
                low = middle + 1;
            } else if (valueToFind < current) {
                // иначе сдвигаем правую границу
                high = middle - 1;

            } else {
                index = middle;
                break;
            }
        }
        // проверили весь массив, но не нашли элемент
        return index;

    }
}

