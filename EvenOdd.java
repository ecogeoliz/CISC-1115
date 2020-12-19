/* Lizbeth Martinez
 * Program #3
 * Description: A method called introduction will print out my name and then 
 * print several lines of output explaining what the program does and how to end the set of data. 
 * The user will be asked for an integer value and end if a negative value is typed. 
 * Isiteven determines if the integer is even and sends the answer back to main. 
 * The main program prints the answer returned together with a message.
 * 
 * If the integer is even, sumEvenSquares will compute the sum of the first n (integer value) squares.
 * The sum is returned to the main program and the main program prints a message giving n (integer value)
 * and the sum of the first n (integer value) even squares.
 * 
 * If the integer is odd, sumOddNumbers will compute the sum of the first n (integer value) odd numbers.
 * The sum is returned to the main program and the main program prints a message giving n (integer value)
 * and the sum of the first n (integer value) odd numbers.
 * 
 * After calling a method to compute the appropriate sum and printing the result, 
 * the main program will skip a few lines and fall back to step 1, being asked for an integer value. 
 * If a negative value is typed, the program will end.
 * 
 * When the program ends, the amount of data values entered and processed will be printed.
 * 
 */
import java.io.*;
import java.util.Scanner;

public class EvenOdd{
 public static void main(String[] args) throws IOException {
  PrintWriter outputFile = new PrintWriter("myoutput.txt");
  Scanner keyboard = new Scanner(System.in);
  int total = 0;
  int n;
  introduction(outputFile);
  /* Prints out my name and
   * Prints several lines of output explaining what the program does and how to end the set of data.
  */ 
  System.out.println();

  System.out.println("Enter an integer (enter -1 to stop)");
  n = keyboard.nextInt();
  while (n != -1) { // main
   total++;
   outputFile.println("The original integer is "+n);
   if (Isiteven(n)) {
    outputFile.println(n + " is an even number");
    outputFile.println("The sum of first " + n + " even numbers is " + sumEvenSquares(n));
    outputFile.println();
   } else {
    outputFile.println(n + " is an odd number");
    outputFile.println("The sum of first " + n + " odd numbers is " + sumOddNumbers(n));
    outputFile.println();
   }
   System.out.println();
   System.out.println("Enter an integer (enter -1 to stop)"); // ask for integer and end if negative
   n = keyboard.nextInt();
  }
  // amount of data entered and processed print
  outputFile.print(total + " is the amount entered and processed.");

  keyboard.close();
  outputFile.close();
 }

 public static void introduction(PrintWriter outputFile) {
  outputFile.println("My name is Lizbeth Martinez.");
  outputFile.println();
  outputFile.println("This program will ask for an integer value and end if a negative value is typed.\n"+
                     "Isiteven determines if the integer is even and sends the answer to the main.\n"+
                     "If the integer is even, sumEvenSquares will be calculated and sent back to the main.\n"+
                     "If the integer is odd, sumOddNumbers will be calculated and sent back to the main.\n"+
                     "The main will call a method to compute the sum and print the result.\n"+
                     "The main will return to step one: asking for an integer and ending if negative.\n"+
                     "The amount of data entered and processed will print once the program ends.\n");               
 }

 public static boolean Isiteven(int n) {// Isiteven
  if (n % 2 == 0)
   return true; // blank is an even number rewrite
  else
   return false; // blank is an odd number rewrite
 }
 
 // code for even
 /*
  * method sumEvenSquares() Input:
  * n - the number of squares to sum
  * finds the sum of the first n even squares
  * by finding (2n)*(2n)
  * Output:
  * returns the sum of the first n even squares
  */
 public static int sumEvenSquares(int n) {
  int evensum = 0;
  for (int i = 1; i <= n; i++)
   evensum += (2 * i) * (2 * i);
  return evensum;
 }

 // code for odd
 /*
  * method sumOddSquares() Input:
  * n - the number of squares to sum
  * finds the sum of the first n odd numbers
  * by finding (2n-1)
  * Output:
  * returns the sum of the first n odd numbers
  */
 public static int sumOddNumbers(int n) {
  int oddsum = 0;
  for (int i = 1; i <= n; i++)
   oddsum += (2 * i - 1);
  return (oddsum);
 }
 // After calling code, skip a few lines and go back to step 1: asking for an integer.
}
