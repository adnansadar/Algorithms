import java.util.*;
public class MaxSumSubmatrix
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int arr[3][4] = {-6,-4,-1,
						 -3, 2, 4,
						  2, 5, 8,
						  0, 1, 2};
	  	int sum = 0;
		for (int i=0;i<3 ;i++ ) 
		{
			for (int j=0;j<4 ;j++ ) 
			{
				arr[i][j]+arr[i+1][j]+arr[i][j+1]+arr[i+1][j+1];			
			}	
		}
	}
}