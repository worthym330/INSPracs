package ins.programs;
import java.util.Arrays;
import java.util.Scanner;
public class rail {
    public static void Encrypt(String str, int n)
    {
        if (n == 1)
        {
            System.out.print(str);
            return ;
        }
        char[] str1 = str.toCharArray();
        int len = str.length(); 
        String[] arr = new String[n]; 
        Arrays.fill(arr, "");
        int row = 0;
        boolean down = true;
        for (int i = 0; i < len; i++) 
        {
            arr[row] = arr[row] + (str1[i]); 
            if (row == n - 1) 
            {
                down = false;
            }
            else if (row == 0) 
            {
                down = true;
            }
            if (down)
            {
                row++;
            }
            else
            {
                row--;
            }
        }
        for (int i = 0; i < n; i++)
        {
            System.out.print(arr[i]);
        }
    }
    public static void main(String args[]) 
    {
        System.out.println("479 Basant Mandal ");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String for Encryption: ");
        String str = new String();
        str = sc.next(); //plaintext from user
        System.out.println("Enter the String for Depth: ");
        int n = sc.nextInt(); //key / rows
        System.out.println("Encrypted String: ");
        Encrypt(str, n);
    }
}
