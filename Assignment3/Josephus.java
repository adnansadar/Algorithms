import java.util.*;

public class Josephus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value of n and k:");
        int n = sc.nextInt();
        int k = sc.nextInt();
        josephus(n, k);
        sc.close();
    }

    private static void josephus(int n, int k) {
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = (sum + k) % i;   
        }
        System.out.println("The winner is: "+(sum+1));
    }
}