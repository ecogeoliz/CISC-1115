/* Lizbeth Martinez
 * Program #6
 * Description: Main program calls a method to read in (from an input file) a set of people's three-digit ID numbers 
 * and their donations using parallel arrays.
//arrays idNumbers, donations
 * Main program calls a method to sort the ID numbers into numerical order, 
 * being sure to carry along the corresponding donations.
 * 
 * Main program calls a method to print the sorted list in tabular form, giving both ID numbers and donations.
//printing of selectionIDsort

 * Main program calls a method to sort the donation amounts into descending order, 
 * carrying along the corresponding ID numbers.
 * 
 * Main program calls a method to print the sorted lists, giving both ID numbers and donations.
//printing of donatesort

 * Main program calls a method to print some statistics: id and amount of highest donor, median donation value OR 
 * average of the 2 middle donors.
 */
import java.io.*;
import java.util.Scanner;

public class SortingArrays{
  public static void main (String[]args) throws Exception{
    Scanner infile=new Scanner(new File("Input6.txt"));
    PrintWriter outputFile = new PrintWriter("6output.txt");
    int [] idNumbers = new int[50];
    double [] donations = new double [50];
    int donorCount = readData(idNumbers,donations,infile);
    outputFile.println("Original");
    printData(idNumbers,donations,donorCount,outputFile);
    selectIDsort(idNumbers,donations,donorCount);
    outputFile.println("Sorted by ID"); //selection sort
    printData(idNumbers,donations,donorCount,outputFile);
    bubblesort(idNumbers,donations,donorCount);
    outputFile.println("Sorted by Donation"); //bubble sort
    printData(idNumbers,donations,donorCount,outputFile);
    outputFile.println("Statistics");
    mediandonor(idNumbers,donations,donorCount,outputFile);
    highestdonor(idNumbers,donations,donorCount,outputFile);
   
    infile.close();
    outputFile.close();
  } //end of main program

  /* method readData
   * Input: idNumbers, donations, infile
   * Process: Declare and create the input file variable. Do not forget to throw exceptions. Read in the sets of 
   * lines of data, each of which contains a three-digit integer ID number and a donation in dollars and cents.
   * Input file is read until end-of-life is reached. donorCount is the return value for how many sets of data were read 
   * in. Calls the arrays idNumbers and donations.
   * Output: Number of lines that was read in from the input file.
   */
  public static int readData (int[] idNumbers,double[] donations,Scanner infile)throws Exception{
    int i;
    for (i=0;infile.hasNextInt();i++){
     int id=infile.nextInt();
     double donate=infile.nextDouble();
     idNumbers[i]=id;
     donations[i]=donate;
    }
   return i;
  }
   /* method printData
   * Input: idNumbers, donations
   * Process: Prints original set of data in the form of a neat table. When arrays print, there is an overall heading.
   * Headings are also given for the columns of ID numbers and donations.
   * Output: Prints the headings for the columns and the original set of data.
   */
  public static void printData (int[] idNumbers,double[] donations,int donorCount,PrintWriter outputFile){
    outputFile.println("ID Numbers "+"Donations ");
    
    for (int i=0;i<donorCount;i++){
       outputFile.println(idNumbers[i]+"         "+donations[i]);
    }
    outputFile.println(); //empty line for formatting
  }
  
   /* method selectIDsort
   * Input:donorCount,idNumbers,donations
   * Process: Sort the ID numbers using a selection sort. Maintain the match-up of ID numbers and donations.
   * Output: Sorting is finished and it returns to the main program.
   */
  public static void selectIDsort (int[] idNumbers,double[] donations,int donorCount){
      int temp;
      double store;
      int indexOfMin;
      for (int pos=0;pos<idNumbers.length-1;pos++){ //sorting of donors in total
        indexOfMin=pos;
        for (int i=pos+1;i<donorCount;i++){
          if (idNumbers[i]<idNumbers[indexOfMin]){    //first element in id is greater than second element
          indexOfMin=i;
          }
        } //close inner for loop b/c it doesn't do swapping. Finished comparing at this point.
        
        if(indexOfMin!=pos){
        temp=idNumbers[indexOfMin];
        idNumbers[indexOfMin]=idNumbers[pos];
        idNumbers[pos]=temp;
      
        store=donations[indexOfMin];
        donations[indexOfMin]=donations[pos];
        donations[pos]=store;
  
        } //close second if statement
  } //close outer for loop
  }//close the method

   /* method bubblesort
   * Input:donorCount,idNumbers,donations
   * Process: Sort the donations into descending numerical order. Maintain the match-up of ID numbers and donations.
   * Output: Sorting is finished and it returns to the main program.
   */
  public static void bubblesort(int[] idNumbers,double[] donations,int donorCount){
    boolean swapped; //keeping track of swaps
    int temp;
    double store;
    do{
      swapped=false;
      for (int i=0;i<(donorCount-1);i++){ //minus one since you don't swap last element
        if (donations[i]<donations[i+1]){
          store=donations[i];
          donations[i]=donations[i+1];
          donations[i+1]=store;
          
          temp=idNumbers[i];
          idNumbers[i]=idNumbers[i+1];
          idNumbers[i+1]=temp;
          
          swapped=true;
        } //close if statement
      } //close for loop
    } while (swapped);  //while is a statement, not a loop
  } // close method
      
   /* method mediandonor
   * Input:donorCount,idNumbers,donations
   * Process: Taking of the average of donations and if not, finding the middle element.
   * Output: Prints out the stats on what the average donation amount was.
   */
  public static void mediandonor(int[] idNumbers, double[] donations, int donorCount, PrintWriter outputFile){
    if(donorCount%2==0){ //if it's even
      double avg;
      avg=(donations[donorCount/2]+donations[(donorCount/2)-1])/2;
      outputFile.println("Median donor: "+avg);
    }
    else  //if it's odd
      outputFile.println("Median donor: "+idNumbers[donorCount/2]+" "+donations[donorCount/2]);
  } //end of method
  
   /* method highestdonor
   * Input:donorCount,idNumbers,donations
   * Process: Calculates who gave the highest donation amount and prints it in the method.
   * Output: Prints out the stats on who gave the most.
   */
  public static void highestdonor (int[] idNumbers, double[] donations, int donorCount, PrintWriter outputFile){
    bubblesort(idNumbers,donations,donorCount); //sorted donations in descending order
    outputFile.println("Highest donor: "+idNumbers[0]+" "+donations[0]);  
  } //end of method
  
} //end of program
