import java.util.*;

class QuickSortDComparisons {
    static int N;
    static int arr[];
    int[][] T = new int[N][N];

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Enter N: ");
        N = sc.nextInt();
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = random.nextInt(100000);
        }
        QuickSortDComparisons ob = new QuickSortDComparisons();
        ob.sort(arr, 0, N - 1);
        ob.comparisons();
        // System.out.println("sorted array");
        // printArray(arr);

        sc.close();
    }

    int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
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

    void sort(int arr[], int low, int high) {
        if (low < high) {

            int pi = partition(arr, low, high);

            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    void comparisons() {
        System.out.println("No of comparisons of pair i,j:");
        System.out.println("00\t 01\t 02\t 03\t 04\t 05\t 06\t 07\t 08\t 09");
        for (int i = 0; i < T.length; i++) {
            for (int j = 0; j < T.length; j++) {
                System.out.print(T[i][j] + "\t ");
            }
            System.out.println();
        }
    }
}