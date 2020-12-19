/*Lizbeth Martinez
 * Program #5
 * Description: The main program will call a series of methods to process a set of data.
 * One method will read data into two arrays.
 * Second method will print the values stored in an array.
 * Third method will find the smallest of the values stored in an array.
 * Fourth method will construct a new array from two existing arrays.
 * Fifth method will compare the values in the two arrays.
 * Use files for both input and output. Be sure to pass the file variable to any method that will need it.
 */

import java.io.*;
import java.util.Scanner;

public class Arrays{
  public static void main (String[]args) throws IOException{
    Scanner infile=new Scanner(new File("Input5.txt"));
    PrintWriter outputFile = new PrintWriter("5output.txt");
    int n=infile.nextInt();
    int[] score1=new int [50]; //two different arrays of same size
    int[] score2=new int[50];
    readData(n,score1,score2,infile);
    outputFile.println("There are "+n+" values in each array.");
    outputFile.println("The score1 array:");
    printArray (n,score1, outputFile);
    outputFile.println("The score2 array:");
    printArray (n,score2, outputFile);
    outputFile.println();
    int small1=smallest(n,score1); //declaring the smallest n in array score1
    int small2=smallest(n,score2); //declaring the smallest n in array score2
    outputFile.println("The smallest value in score1 is "+small1);
    outputFile.println("The smallest value in score2 is "+small2);
    outputFile.println();
    int [] sumscore=new int [50];
    construct (n,score1,score2,sumscore); //array parameter is sumscore
    outputFile.print("The sumscore array:");
    printArray (n,sumscore, outputFile);
    outputFile.println();
    int smallsum=smallest(n,sumscore); //declaring the smallest n in array sumscore
    outputFile.println("The smallest value in sumscore is "+smallsum);
    outputFile.println();
    whatsHigher(n,score1,score2, outputFile);
    
    infile.close();
    outputFile.close();
  } //end of main program
   
  /* method readData
   * Input: n, nums1, nums2
   * Process: Created a for loop for the integer to put placed in.
   * Output: nums1 and nums2 reads in data from input file.
   */
  public static void readData (int n,int[] nums1,int[] nums2,Scanner infile){
    for (int i=0;i<n;i++){
      nums1[i]=infile.nextInt();
      nums2[i]=infile.nextInt();
    }
  }
   
  /* method printArray
   * Input: lim, vals
   * Process: Created a for loop for the integer to print in.
   * Output: The numbers in the array will print on one line with spacing.
   */
  public static void printArray (int lim, int[]vals, PrintWriter outputFile){
    for (int i=0;i<lim;i++){
      outputFile.print(vals[i]+" ");
  }
    outputFile.println();
  }
   /* method smallest
   * Input: num, arr
   * Process: min is used as the smallest value in an array. The for loop moves the numbers
   * and the if statement compares the numbers.
   * Output: The smallest value in the array.
   */
  public static int smallest(int num, int[]arr){
    int min=arr[0];
    for (int i=1;i<num;i++){
       if (min>arr[i])
         min=arr[i];
    }
    return min;
  }
   /* method construct
   * Input: k, old1, old2, sumarr
   * Process: For loop moves the numbers. Adds the element of the first array and the second array.
   * Output: Set the values for sum array.
   */
  public static void construct (int k, int[] old1, int[]old2, int[]sumarr){
    for (int i=0;i<k;i++){ //k is set number.
     sumarr[i]=old1[i]+old2[i];
    }
  }
   /* method whatsHigher
   * Input: score1,score2,n
   * Process: Set up counters and use the for loop to move the numbers. If and if/else statements determined
   * what value was higher and it prints out a corresponding message, increment, and count.
   * Output: Output file had statements and values for whatsHigher. Prints out how many times it was higher and 
   * when it was higher.
   */
  public static void whatsHigher (int n, int[] score1, int[]score2, PrintWriter outputFile){
    int large1=0; //counters
    int large2=0;
    int equal=0;
    for (int i=0;i<n;i++){
     outputFile.print("In position "+i);
     if (score1[i]>score2[i]){
     large1++;
     outputFile.print(" the higher value is in array score1: "+score1[i]+" is higher than "+score2[i]);
     }
     else if (score2[i]>score1[i]){
     large2++;
     outputFile.print(" the higher value is in array score2: "+score2[i]+" is higher than "+score1[i]);
     }
     else if (score1[i]==score2[i]){
     equal++;
     outputFile.print(" the value is the same in both arrays: "+score1[i]);  
     }
     outputFile.println();
}
     outputFile.println();
     outputFile.println("Array score1 was larger "+large1+" time(s)");
     outputFile.println("Array score2 was larger "+large2+" time(s)");
     outputFile.println("The two arrays were equal "+equal+" time(s)");
  }
}
    
    
    









