
    // Java program to illustrate Randomised Quick Sort 
import java.util.*;

class QuickSortR {
    public static int N = 5;
    public static int[] arr = new int[N];

    // This Function helps in calculating random
    // numbers between low(inclusive) and high(inclusive)
   

    int partition(int arr[], int low, int high) {
        Random rand = new Random();
        int pivot = rand.nextInt(high - low) + low;

        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot) {
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

    /*
     * The main function that implements QuickSort() arr[] --> Array to be sorted,
     * low --> Starting index, high --> Ending index
     */
    void sort(int arr[], int low, int high) {
        if (low < high) {
            /*
             * pi is partitioning index, arr[pi] is now at right place
             */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }


    // Driver code
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Enter n: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        long[] time = new long[n];

        QuickSortR ob = new QuickSortR();
        // Randomised Quick Sort
        System.out.println("Randomised Sort:");
        for (int i = 0; i < n; i++) {

            long start = System.nanoTime();
            ob.sort(arr, 0, n - 1);
            // System.out.println("sorted array");
            // printArray(arr);
            long end = System.nanoTime();
            time[i] = end - start;
        }
        int maxrandomised = 0, min = 0, avgrandomised = (int) time[0];

        for (int i = 1; i < time.length; i++) {
            System.out.println("Test Case " + i + ": " + time[i] + "ms");
            if (time[i] < time[min]) {
                min = i;
            }
            if (time[i] > time[maxrandomised]) {
                maxrandomised = i;
            }

            avgrandomised += time[i];
        }
        avgrandomised = avgrandomised / n;

        System.out.println("\nBest Case: " + time[min] + "ms");
        System.out.println("Worst Case: " + time[maxrandomised] + "ms");
        System.out.println("Average Case: " + avgrandomised + "ms\n");

        // System.out.println("sorted array");
        // printArray(arr);
        long end = System.nanoTime();
        System.out.println("Time Taken: " + (end - start) + "ms");
        sc.close();
    }
}
