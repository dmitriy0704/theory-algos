# Алгоритмы

## Поиск

### Линейный поиск

Сложность O(N), т.е. кратная количеству элементов.

```java
public class Main {
    public static void main(String[] args) {
        int[] integerArray = {-183, 12, 15, 40, 234, 345, 800, 977800, 345, 977};
        int elementToFind = 977800;
        System.out.println(target);
    }

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
```

### Бинарный поиск

В О-нотации сложность алгоритма равна O(log(N)).

#### Итеративная реализация

```java
public class Binary {

    public static void main(String[] args) {
        int[] values = {1, 1, 2, 3, 4, 10};
        int valueToFind = 3;

        System.out.printf("Index = %d%n", binarySearch(values, valueToFind, 0, values.length - 1));
    }

    private static int binarySearch(int[] sortedArray, int valueToFind, int low, int high) {
        int index = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (sortedArray[mid] < valueToFind) {
                low = mid + 1;
            } else if (sortedArray[mid] > valueToFind) {
                high = mid - 1;
            } else if (sortedArray[mid] == valueToFind) {
                index = mid;
                break;
            }
        }
        return index;
    }

}
```

#### С использованием рекурсии

```java

public class Main {
    public static void main(String[] args) {
        int[] integerArray = {-183, 12, 15, 40, 234, 345, 800, 977800, 345, 977};
        int elementToFind = 977800;
        Arrays.sort(integerArray); //-> [-183, 12, 15, 40, 234, 345, 345, 800, 977, 977800]
        System.out.println("Element " + elementToFind + " found, index: " +
                binarySearch(integerArray, elementToFind, 0, integerArray.length - 1));
    }

    public static int binarySearch(int[] sortedIntegerArray, int elementToFind, int low, int high) {
        //   В данном примере происходит следующее:
        //
        //  1. В методе binarySearch мы принимаем упорядоченный (отсортированный) массив целых чисел.
        //  2. Проверяем, чтобы low был меньше high (low = 0, high = 9) – получаем false
        if (low > high) {
            return -1;
        }

        //  3. Получаем середину массива – 234
        int mid = low + (high - low) / 2;

        //  4. Сравниваем 234 с искомым значением 977800 – 977800 больше.
        //-> 977800 < 234
        if (elementToFind < sortedIntegerArray[mid]) {
            return binarySearch(sortedIntegerArray, elementToFind, low, mid - 1);

            //  5. Отсекаем левую часть массива и получаем новые low – 5 и high – 9.
        } else if (elementToFind > sortedIntegerArray[mid]) {
            //-> 977800 > 234
            return binarySearch(sortedIntegerArray, elementToFind, mid + 1, high);
        } else {
            return mid;
        }


        //  6. Новая медиана – 977800
        //  7. Попадаем в условие else – возвращаем индекс 7.


    }
}


```