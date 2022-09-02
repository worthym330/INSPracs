
package ins.programs;
import java.util.Scanner;
public class Monoalph {
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	public static String Encrypt(String plainText,int Key)
	{
		plainText = plainText.toLowerCase();
		String cipherText = "";
		for (int i = 0; i < plainText.length(); i++)
        {
            int charPositionPT = ALPHABET.indexOf(plainText.charAt(i)); 
            int finalPosition = charPositionPT+Key;
            if(finalPosition > 25)
            {
            	finalPosition = finalPosition - 26;  
            }
            char replaceVal = ALPHABET.charAt(finalPosition);
            cipherText += replaceVal; 
        }		
		return cipherText;		
	}
	public static String Decrypt(String cipherText,int Key)
	{ 
		cipherText = cipherText.toLowerCase();
		String plainText = "";
		for (int i = 0; i < cipherText.length(); i++)
        {
            int charPositionCT = ALPHABET.indexOf(cipherText.charAt(i));
            int finalPosition = charPositionCT-Key;
            if(finalPosition < 0)
            {
            	finalPosition = finalPosition + 26;
            }
            char replaceVal = ALPHABET.charAt(finalPosition);
            plainText += replaceVal;
        }		
		return plainText;		
	}
	public static void main(String[] args) {
		System.out.println("479 Basant Mandal");		
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter the String for Encryption: ");
		String message = new String();	
		message = sc.next();			
                System.out.println("Enter the key for Encryption: ");
                int key = sc.nextInt();
                System.out.println("Encrypted Text:");
                System.out.println(Encrypt(message, key));
                System.out.println("Decrypted Text:");
                System.out.println(Decrypt((Encrypt(message, key)), key));
                sc.close();
}
}

