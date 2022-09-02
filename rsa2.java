package ins.programs;
import java.util.Scanner;
public class rsa2 {
    public static int pvtkey;
    public static void rsa(int p,int q){
        int N=p*q;
        int m=(p-1)*(q-1);
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter value for public key");
        int e=sc.nextInt();
        boolean chprime= checkprime(e);
        if (chprime){
            int [] a = new int[25];
            int [] b = new int[25];
            int [] d = new int[25];
            int [] k = new int[25];
            a[0]=1;
            b[0]=0;
            d[0]=m;
            k[0]=0;
            a[1]=0;
            b[1]=1;
            d[1]=e;
            k[1]=d[0]/d[1];
            System.out.println("a" + "\t " + "b" + "\t " +" d" + "\t " + "k");
            System.out.println(a[0] + "\t " + b[0] + "\t " + d[0] + "\t " + k[0]);
            System.out.println(a[1] + "\t " + b[1] + "\t " + d[1] + "\t " + k[1]);
            int i=2;
            while(d[i]!=1){
                a[i]=a[i-2]-(a[i-1]*k[i-1]);
                b[i]=b[i-2]-(b[i-1]*k[i-1]);
                d[i]=d[i-2]-(d[i-1]*k[i-1]);
                k[i]=d[i-1]/d[i];
                System.out.println(a[i] + "\t " + b[i] + "\t " + d[i] + "\t " + k[i]);
                if (d[i]==1) 
                    pvtkey = b[i];
                 else 
                    i++;
            }
            if (pvtkey>m) 
                pvtkey %= m;
            else if(pvtkey<0)
                pvtkey += m;
            else 
                System.out.println("The public key you chose is not a prime number.");
            } 
        else 
            System.out.println("The public key you chose is bigger than derived number " +m); 
        System.out.println(); 
        System.out.println("*************************************************");  
        System.out.println("Public Key: " + e); 
        System.out.println("Private Key: " + pvtkey); 
        System.out.println("*************************************************");   
        }
        public static boolean checkprime(int  input){
            boolean prime=true;
            if (input<=1)
                prime=false;
            else{
                for (int i=2; i<=input; i++)
                {
                    if (input%i==0){
                        prime=false;
                        break;
                    }
                }
            }
            return prime;
        }
        public static void main(String args[]){
            Scanner sc=new Scanner(System.in);
            System.out.println("479 Basant Mandal");
            System.out.println("Enter the value of p ");
            int p = sc.nextInt();
            boolean isPrime=checkprime(p);
            if(isPrime){
                System.out.println("Enter the value of q ");
                int q = sc.nextInt();
                isPrime=checkprime(q);
                if(isPrime)
                    rsa(p,q);
                else 
                    System.out.println("q is not a prime number ");
            }
            else 
                System.out.println("p is not a prime number ");
        } 
    }

