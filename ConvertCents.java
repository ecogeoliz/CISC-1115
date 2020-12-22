import java.util.Scanner;

public class ConvertCents {
 
   public static void main (String[] args) {   
     int cents;
     int fewdollar,fewquarter,fewdime,fewnickels;
     int coins;
// User input coming from the scanner
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Enter value representing cents: ");
      cents = keyboard.nextInt();
      System.out.println();
//computations 
      int dollars=100; //100 cents equals a dollar
      fewdollar=cents/dollars;
      coins=cents%dollars; //remainder from dollars
      int quarters=25; //25 cents equals a quarter
      fewquarter=coins/quarters;
      coins=coins%quarters; //remainder after taking the quarters
      int dime=10; //10 cents equals a dime
      fewdime=coins/dime;
      coins=coins%dime; //remainder after taking the dimes
      int nickels=5; //5 cents equals a nickel
      fewnickels=coins/nickels;
      coins=coins%nickels; //remainder after taking the nickels
//print statement
System.out.println(fewdollar+" dollars, "+fewquarter+" quarters, "+fewdime+" dime, "+fewnickels+" nickels, "+coins+" pennies");

   }
}