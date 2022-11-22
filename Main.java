import java.util.Random;

public class Main {
    static int[] insertionSort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }

        return arr;
    }

    static void exibeArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    public static int[] mergeSort(int[] arr, int lo, int hi) {

        if (lo == hi) {
            int[] ba = new int[1];
            ba[0] = arr[lo];
            return ba;
        }

        int mid = (lo + hi) / 2;
        int arr1[] = mergeSort(arr, lo, mid);
        int arr2[] = mergeSort(arr, mid + 1, hi);
        return merge(arr1, arr2);
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int i = 0, j = 0, k = 0;
        int n = arr1.length;
        int m = arr2.length;
        int[] arr3 = new int[m + n];
        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                arr3[k] = arr1[i];
                i++;
            } else {
                arr3[k] = arr2[j];
                j++;
            }
            k++;
        }

        while (i < n) {
            arr3[k] = arr1[i];
            i++;
            k++;
        }

        while (j < m) {
            arr3[k] = arr2[j];
            j++;
            k++;
        }

        return arr3;

    }

    public static void main(String[] args) {
        int[] array20 = new int[20];
        int[] array20000 = new int[20000];

        Random objGenerator = new Random();

        for (int i = 0; i < 20; i++) {
            int randomNumber = objGenerator.nextInt(10000);
            array20[i] = randomNumber;
        }

        for (int j = 0; j < 20000; j++) {
            int randomNumber = objGenerator.nextInt(10000);
            array20000[j] = randomNumber;
        }

        long startInsercionSort20 = System.nanoTime();

        int[] so20InsercionSort = insertionSort(array20);

        long endInsercionSort20 = System.nanoTime();

        long startMergeSort20 = System.nanoTime();

        int[] so20mergeSort = mergeSort(array20, 0, array20.length - 1);

        long endMergeSort20 = System.nanoTime();

        exibeArray(so20InsercionSort);
        exibeArray(so20mergeSort);


        long startInsercionSort20000 = System.nanoTime();
        int[] so20000InsercionSort = insertionSort(array20000);
        long endInsercionSort20000 = System.nanoTime();

        long startMergeSort20000 = System.nanoTime();
        int[] so20000mergeSort = mergeSort(array20000, 0, array20000.length - 1);
        long endMergeSort20000 = System.nanoTime();

        System.out.println(" ");

        exibeArray(so20000InsercionSort);
        exibeArray(so20000mergeSort);

        System.out.println(" ");
        System.out.println(" ");

        System.out.println("Tempo em insertionSort com 20: " + (endInsercionSort20 - startInsercionSort20));
        System.out.println("Tempo em merge sort com 20: " + (endMergeSort20 - startMergeSort20));

        System.out.println(" ");

        System.out.println("Tempo em insertionSort com 20000: " + (endInsercionSort20000 - startInsercionSort20000));
        System.out.println("Tempo em merge sort com 20000: " + (endMergeSort20000 - startMergeSort20000));
    }
}