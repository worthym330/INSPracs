package ins.programs;
import java.util.Scanner;
public class sc {
    public static void Encrypt(String plainText, String key)
        {
        String pt[]=plainText.split(""); 
        String ky[]=key.split(""); 
        int columns = key.length();
        int rows;
        if(plainText.length() % columns == 0)
        {
            rows = (plainText.length())/columns + 1;
        }
        else
        {
            rows = (plainText.length()/columns) + 2;
        }
        String[][] mat = new String[rows][columns];
        String var="";
        int c = 0;
        for(int i = 0; i < columns; i++)
        {
            mat[0][i] = ky[i];
        }
        for(int i = 1; i < rows; i++)
        {
        for(int j = 0; j< columns; j++)
        {
        if(c != plainText.length()) 
        {
        var = pt[c]; 
        mat[i][j]=var; 
        c++;
        }
        else
        break;
        }
        }
        for(int i = 0; i < rows; i++)
            {
                for(int j = 0; j< columns; j++)
                {
                    if(mat[i][j] == null)
                    {          mat[i][j]="X";}}}
        for(int i = 0; i < rows; i++)
            {
                for(int j = 0; j< columns; j++)
                {
                    System.out.print(mat[i][j]+"\t");
                }
                System.out.println();
            }
        String output="";
        for(int i = 0; i < columns; i++)
            {
            for(int j = 1; j< rows ; j++)
                {
                    output=output+mat[j][i];
                }
            }
            System.out.println("Encrypted String: "+output);
        }
        public static void main(String[] args) {
            System.out.println("479 Basant Mandal");
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the String for Encryption: ");
            String str = new String();
            str = sc.next();
            System.out.println("Enter the key for Encryption: ");
            String key = new String();
            key = sc.next();
            Encrypt(str,key);
        }
}

