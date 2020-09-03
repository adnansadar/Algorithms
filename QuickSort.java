import java.util.*;

class QuickSort {
    public static int N = 5;
    public static int[] arr = new int[N];

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Enter n: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        long[] time = new long[n];

        QuickSort ob = new QuickSort();
        // Randomised Quick Sort
        System.out.println("Randomised Sort:");
        for (int i = 0; i < n; i++) {

            long start = System.nanoTime();
            ob.randomisedSort(arr, 0, n - 1);
            // System.out.println("sorted array");
            // printArray(arr);
            long end = System.nanoTime();
            time[i] = end - start;
        }
        int max = 0, min = 0, avg = (int) time[0];

        for (int i = 1; i < time.length; i++) {
            System.out.println("Test Case " + i + ": " + time[i] + "ms");
            if (time[i] < time[min]) {
                min = i;
            }
            if (time[i] > time[max]) {
                max = i;
            }

            avg += time[i];
        }
        avg = avg / n;

        System.out.println("\nBest Case: " + time[min] + "ms");
        System.out.println("Worst Case: " + time[max] + "ms");
        System.out.println("Average Case: " + avg + "ms\n");

        // Deterministic Quick Sort
        System.out.println("Deterministic Sort:");
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(100000);
            long start = System.nanoTime();
            ob.deterministicSort(arr, 0, n - 1);
            // System.out.println("sorted array");
            // printArray(arr);
            long end = System.nanoTime();
            time[i] = end - start;
        }
        max = 0;
        min = 0;
        avg = (int) time[0];
        for (int i = 1; i < time.length; i++) {
            System.out.println("Test Case " + i + ": " + time[i] + "ms");
            if (time[i] < time[min]) {
                min = i;
            }
            if (time[i] > time[max]) {
                max = i;
            }

            avg += time[i];
        }
        avg = avg / n;

        System.out.println("\nBest Case: " + time[min] + "ms");
        System.out.println("Worst Case: " + time[max] + "ms");
        System.out.println("Average Case: " + avg + "ms");
        sc.close();
    }

    int randomisedPartition(int arr[], int low, int high) {
        Random rand = new Random();
        int pivot = rand.nextInt(high - low) + low;

        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {

            if (arr[j] <= pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    void randomisedSort(int arr[], int low, int high) {
        if (low < high) {
            int pi = randomisedPartition(arr, low, high);
            randomisedSort(arr, low, pi - 1);
            randomisedSort(arr, pi + 1, high);
        }
    }

    int deterministicPartition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            if (arr[j] < pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    void deterministicSort(int arr[], int low, int high) {
        if (low < high) {

            int pi = deterministicPartition(arr, low, high);

            deterministicSort(arr, low, pi - 1);
            deterministicSort(arr, pi + 1, high);
        }
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver code

}