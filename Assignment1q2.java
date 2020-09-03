import java.util.*;

class Assignment1q2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		int[] adjacent = { 2, 3, 2, 3, 4, 3, 2, 3, 2 };
		System.out.println("Enter the 3x3 matrix: ");
		for (int i = 0; i < arr.length - 1; i++) {
			arr[i] = sc.nextInt();
		}
		Assignment1q2 ob = new Assignment1q2();
		ob.checkBalanced(arr, adjacent);
	}

	void checkBalanced(int[] arr, int[] adjacent) {
		int check = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if (adjacent[i] < arr[i]) {
				check = 1;
				break;
			}
		}
		if (check == 1) {
			System.out.println("The matrix is Unbalanced");
		} else {
			System.out.println("The matrix is Balanced");
		}
	}
}