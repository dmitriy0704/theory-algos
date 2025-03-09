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