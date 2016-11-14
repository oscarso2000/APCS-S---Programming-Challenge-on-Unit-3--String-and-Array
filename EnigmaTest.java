
/**
 * Write a description of class EnigmaTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Scanner;
public class EnigmaTest
{
   public static char check = 'y';
   public static void end(){
       System.out.printf("Invalid Input. Bye. \n");
   }
   public static void check(){
       System.out.printf("Do you want to continue? Press y to continue.\n");
       Scanner checkInput = new Scanner(System.in);
       check = checkInput.next().charAt(0);
   } 
   public static void main(String [] args){
       do{
          Enigma e = new Enigma();
          System.out.printf("Hello!\nPress 1 to encrypt\nPress 2 to decrypt.\n");
          Scanner numInput = new Scanner(System.in);
          Scanner cryptInput = new Scanner(System.in);
          String input = "";
          int x = numInput.nextInt();
          if (x==1){
             System.out.printf("Please type in your String:\n");
             input = cryptInput.nextLine();
             System.out.printf("The encrypted message is: %s\n",e.encrypt(input));
             check();
          }else if (x==2){
             System.out.printf("Please type in your String:\n");
             input = cryptInput.nextLine();
             System.out.printf("The decrypted message is: %s\n",e.decrypt(input));
             check();
          }else{
             end();
          }
       }while(check == 'y' || check == 'Y');
   }
}
