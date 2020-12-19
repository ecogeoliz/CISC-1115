/* Lizbeth Martinez
 * Program #2
 * Description: This program will let the user compute statistics for how salespeople did.
 * It will print the results for each salesperson and repeat the process for each new one.
 * This will happen until the entire set of data is taken care of.
 */
import java.util.Scanner;
public class EmployeeSurvey {
  public static void main(String[]args){
  System.out.println("Lizbeth Martinez. This is program 2.");
  int id, purchase, nonpurchase, quota, bonus, total, needs;
  double salespct;
  int numemp=0;
  
  Scanner keyboard = new Scanner (System.in);
  System.out.print("Please enter an ID (enter -1 to stop): "); 
  id = keyboard.nextInt();
  while (id != -1) {
    System.out.print("Enter number of customers who bought: ");
    purchase = keyboard.nextInt();
    System.out.print("Enter number of customers who did not buy: ");
    nonpurchase = keyboard.nextInt();
    System.out.print("Enter the quota:");
    quota = keyboard.nextInt();
    total = purchase + nonpurchase;
    needs = quota - purchase;
    bonus = (purchase * 2) - nonpurchase;
System.out.println("Employee "+id+ "\n Amount purchased "+purchase+ "\n Amount not purchased " +nonpurchase+
                   "\n Quota is "+quota+"\n Total "+total+"\n Employee needs "+needs+"\n Bonus is "+bonus);
   if (purchase >= quota)
   System.out.println("Congratulations");
   if (purchase < quota)
   System.out.println("Try harder");  
  
   if (purchase > nonpurchase)
   System.out.println("More people purchased");
   if (purchase < nonpurchase)
   System.out.println("Less people purchased");
   if (purchase == nonpurchase)
   System.out.println("Same number of people who purchased and did not purchase.");

  salespct=1.00*purchase/total; 
  System.out.printf("The sales percentage is " + "%.3f" ,salespct);
  
  System.out.println( );
  numemp++; 
  System.out.print("Please enter an ID (enter -1 to stop): "); 
  id = keyboard.nextInt();
  System.out.println("\n We have processed "+ numemp + " employee(s) ");
  // By placing -1, the last employee will be processed in order for the total statement to print.
  }
  keyboard.close();
   }
 }