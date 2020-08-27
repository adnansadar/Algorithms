import java.util.*;

class QuickSortD {

    int partition(int arr[], int low, int high) {
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

            int pi = partition(arr, low, high);

            deterministicSort(arr, low, pi - 1);
            deterministicSort(arr, pi + 1, high);
        }
    }

    void randomisedSort(int arr[], int low, int high) {
        if (low < high) {

            int pi = partition(arr, low, high);

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

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Enter n: ");
        int n = sc.nextInt();
        long startDeterministic = System.currentTimeMillis();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(100000);
        }
        QuickSortD ob = new QuickSortD();
        ob.deterministicSort(arr, 0, n - 1);

        System.out.println("sorted array");
        printArray(arr);
        long endDeterministic = System.currentTimeMillis();
        System.out.println("Time Taken: " + (endDeterministic - startDeterministic) + "ms");
        ob.randomisedSort(arr, 0, n - 1);
        sc.close();
    }
}