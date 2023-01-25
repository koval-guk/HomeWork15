import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Integer[] ints = {1, 3, 6, 3, 2, 7, 1, 5};
        System.out.println(Arrays.toString(ints));
        quickSort(ints);
        System.out.println(Arrays.toString(ints));
        System.out.println("*********");
        String[] strings = {"cat", "dog", "racoon", "chicken", "fish", "snake"};
        System.out.println(Arrays.toString(strings));
        quickSort(strings);
        System.out.println(Arrays.toString(strings));
        System.out.println("*********");
        String[] strings1 = {"cat", "cat", "dog", "cat", "cat", "dog", "cat", "cat", "cat", "cat", "cat", "cat"};
        System.out.println(Arrays.toString(strings1));
        quickSort(strings1);
        System.out.println(Arrays.toString(strings1));
        System.out.println("*********");
        Integer[] intArr = {6, 9, 3, 4, 1, 8, -2, -8, 9, 3};
        System.out.println(Arrays.toString(intArr));
        shakerSort(intArr);
        System.out.println(Arrays.toString(intArr));
        System.out.println("*********");
        String[] strings2 = {"cat", "dog", "racoon", "chicken", "fish", "snake", "bird", "bug", "human", "bear", "microbe"};
        System.out.println(Arrays.toString(strings2));
        shakerSort(strings2);
        System.out.println(Arrays.toString(strings2));
    }

    public static <T extends Comparable<T>> void quickSort(T[] array) {
        quickSortMethod(array, 0, array.length - 1);
    }

    private static <T extends Comparable<T>> void quickSortMethod(T[] source, int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        T pivot = source[(leftMarker + rightMarker) / 2];
        do {
            while (source[leftMarker].compareTo(pivot) < 0) {
                leftMarker++;
            }
            while (source[rightMarker].compareTo(pivot) > 0) {
                rightMarker--;
            }
            if (leftMarker <= rightMarker) {
                if (leftMarker < rightMarker) {
                    T tmp = source[leftMarker];
                    source[leftMarker] = source[rightMarker];
                    source[rightMarker] = tmp;
                }
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);
        if (leftMarker < rightBorder) {
            quickSortMethod(source, leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            quickSortMethod(source, leftBorder, rightMarker);
        }
    }

    public static <T extends Comparable<T>> void shakerSort(T[] arr) {
        T temp;
        int left = 0;
        int right = arr.length - 1;
        do {
            for (int i = left; i < right; i++) {
                if (arr[i].compareTo(arr[i + 1]) > 0) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (arr[i].compareTo(arr[i - 1]) < 0) {
                    temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                }
            }
            left++;
        } while (left < right);
    }
}
