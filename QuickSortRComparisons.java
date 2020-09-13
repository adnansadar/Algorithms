import java.util.*;

class QuickSortRComparisons {
    static int N;
    static int arr[];
    int[][] T = new int[N][N];

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter N: ");
        N = sc.nextInt();
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i;
        }
        QuickSortRComparisons ob = new QuickSortRComparisons();
        ob.sort(arr, 0, N - 1);
        ob.comparisons();
        // System.out.println("sorted array");
        // printArray(arr);
        sc.close();
    }


    void random(int low, int high) {

        Random rand = new Random();
        int pivot = rand.nextInt(high - low) + low;

        int temp1 = arr[pivot];
        arr[pivot] = arr[high];
        arr[high] = temp1;
    }

    int partition(int arr[], int low, int high) {
        int pivot = arr[high];

        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot) {
                T[pivot][j] += 1;
                T[j][pivot] += 1;
                
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

    void comparisons()
    {
        for (int i = 0; i < T.length; i++) {
            for (int j = 0; j < T.length; j++) {
                System.out.println(T[i][j]);
            }
        }
    }

    /* A utility function to print array of size n */
    // static void printArray(int arr[]) {
    //     int n = arr.length;
    //     for (int i = 0; i < n; ++i)
    //         System.out.print(arr[i] + " ");
    //     System.out.println();
    // }

    // Driver code
    
}