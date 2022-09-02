package ins.programs;
import java.util.Scanner;
public class caesor {
public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

public static String decrypt(String cipherText, int shiftKey) 
  {
    cipherText = cipherText.toLowerCase();
    String message = "";
    for (int i = 0; i < cipherText.length(); i++) {
      int charPosition = ALPHABET.indexOf(cipherText.charAt(i));
    //  int keyVal = (charPosition + shiftKey) % 26; //encryption
     int keyVal = (charPosition - shiftKey) % 26; //decryption
      
      if (keyVal < 0) {
        keyVal = ALPHABET.length() + keyVal; //same for both 
      }
      char replaceVal = ALPHABET.charAt(keyVal);
      message += replaceVal;
    }
    return message;
  }
public static String encrypt(String cipherText, int shiftKey) 
  {
    cipherText = cipherText.toLowerCase();
    String message = "";
    for (int i = 0; i < cipherText.length(); i++) {
      int charPosition = ALPHABET.indexOf(cipherText.charAt(i));
      int keyVal = (charPosition + shiftKey) % 26; //encryption
      if (keyVal < 0) {
        keyVal = ALPHABET.length() + keyVal; //same for both 
      }
      char replaceVal = ALPHABET.charAt(keyVal);
      message += replaceVal;
    }
    return message;
  }
  public static void main(String[] args) {
    System.out.println("479 Basant Mandal");
    Scanner sc = new Scanner(System.in);
    String message = new String();
    System.out.print("Enter the String for Encryption n Decryption: ");
    message = sc.next();
    System.out.println("Enter Shift Key: ");
    int key = sc.nextInt();
    String demsg=encrypt(message,key);
    System.out.println("Encrpyted msg: "+ demsg);
    System.out.println("\nDecrypted Message:" + decrypt(demsg, key));
  }
}

