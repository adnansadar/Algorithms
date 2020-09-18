import java.io.*;
public class KaratsubaMain {
    public static void main(String[] args) throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter 2 nos:");
        long num1 = Integer.parseInt(br.readLine());
        long num2 = Integer.parseInt(br.readLine());
        System.out.println("Product of the 2 nos is: "+karatsuba(num1, num2));
    }

    private static long karatsuba(long num1, long num2) {
        long xlyl = (num1/100)*(num2/100);
        long xryr = (num1%100)*(num2%100);
        long product1 = ((num1 / 100)+ (num1 % 100))*((num2 / 100)+ (num2 % 100));
        long calculation1 = product1 - xryr - xlyl;
        return ((xlyl*10000) + xryr + (calculation1*100));
    }
}