import java.util.*;
import java.lang.Math;

/**
 * Assignment2
 */
public class Assignment2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // System.out.println("Enter input size: ");
        int[] arr = { 23, 1, 43, 21 };
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            arr[i] = (int) Math.random();
        }
        Assignment2 ob = new Assignment2();
        ob.deterministicSort(arr, 0, n - 1);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public void deterministicSort(int[] arr, int l, int r) {
        if (l < r) {
            int pi = partition(arr, l, r); // find pi
            deterministicSort(arr, l, pi - 1);// sort elements before pi
            deterministicSort(arr, pi + 1, r); // sort elements after pi
        }
    }

    public int partition(int[] arr, int l, int r) {
        int pi = arr[r];
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (arr[j] < pi) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[pi];
        arr[pi] = temp;
        return i + 1;
    }

}