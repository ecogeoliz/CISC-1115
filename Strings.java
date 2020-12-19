/* Lizbeth Martinez
 * Program #7
 * Description: Main method will call a method (readOriginalDate) to read in a string representing a date. 
 * Main program will call other methods (breakOriginalDate,printdate3ways) to process that date. 
 * The main program will repeat the entire procedure for the next date, and the next, etc., for an entire set of data.
 */
import java.io.*;
import java.util.Scanner;

public class Strings{
  public static void main (String[]args) throws Exception{
    Scanner infile=new Scanner(new File("Input7.txt"));
    PrintWriter outputFile = new PrintWriter("7output.txt");
    
    while (infile.hasNext()){
    String orig=readOriginalDate(infile);
    outputFile.println(orig+" is the original date");
    String[]date=breakOriginalDate(orig);
    String month=date[0];
    String day=date[1];
    String year=date[2];
    outputFile.println(month+" is the month "+day+" is the day "+year+" is the year ");
    printdate3ways(day,month,year,outputFile);
    outputFile.println();
    } //end while loop that runs until end of input file
    
    infile.close();
    outputFile.close();
  } //end of main


  /* method readOriginalDate
   * Input:Scanner infile
   * Process: Read in and print a string of characters representing a date
   * Output: Sends the string back to the main program as a return value
   */
public static String readOriginalDate(Scanner infile){
  String orig=infile.next();
  return orig;
}
  /* method breakOriginalDate
   * Input: String readOriginalDate
   * Process: Breaks the original date into 3 pieces:a month, a day, and a two-digit year. Month will be the first part
   * up to the first slash, day will be the second part up to the second slash, and the two-digit year will be the 
   * third part after the second slash of the original date.
   * Output: Prints the original date string, the three parts that it was broken into, and appropriate messages 
   * ("" is the original date,"" is the month,"" is the day, and "" is the year). 
   * Sends the three parts back to the main program in a String array, 
   * keeping the first element as month, second element as day, and the third element being year.
   */
public static String[]breakOriginalDate(String orig){
  String[]date=new String[3]; //3 parts to break
  int m=orig.indexOf("/");
  date[0]=orig.substring(0,m);
  int d=orig.indexOf("/",m+1);
  date[1]=orig.substring(m+1,d);
  date[2]=orig.substring(d+1);
  return date; //returning the string
}

  /* method printdate3ways
   * Input: Strings month,day,year and PrintWriter outputFile
   * Process: Construct and sort the date in a single string variable. Print from that string variable with 
   * an appropriate message (European, American, and Full).
   * Output: Print the date in 3 different ways (European, American, and Full).
   */
public static void printdate3ways(String day,String month,String year,PrintWriter outputFile){
  String european=day+"-"+month+"-"+year;
  outputFile.println(european+" is the European way of printing");
  String full="";
  String american="";
  if (month.equals("1")){
    american+="January ";
    full+="0"+month;
  }
  else if (month.equals("2")){
    american+="February ";
    full+="0"+month;
  }  
  else if (month.equals("3")){
    american+="March ";
    full+="0"+month;
  }   
  else if (month.equals("4")){
    american+="April ";
    full+="0"+month;
  }  
  else if (month.equals("5")){
    american+="May ";
    full+="0"+month;
  }  
  else if (month.equals("6")){
    american+="June ";
    full+="0"+month;
  } 
  else if (month.equals("7")){
    american+="July ";
    full+="0"+month;
  } 
  else if (month.equals("8")){
    american+="August ";
    full+="0"+month;
  } 
  else if (month.equals("9")){
    american+="September ";
    full+="0"+month;
  } 
  else if (month.equals("10")){
    american+="October ";
    full+=month;
  } 
  else if (month.equals("11")){
    american+="November ";
    full+=month;
  } 
  else if (month.equals("12")){
    american+="December ";
    full+=month;
  } 
  american+=day+", 20"+year;
  outputFile.println(american+" is the American way of printing");
  if (day.equals("1")){
    full+="-0"+day;
  }
  else if (day.equals("2")){
    full+="-0"+day;
  }
  else if (day.equals("3")){
    full+="-0"+day;
  }
  else if (day.equals("4")){
    full+="-0"+day;
  }
  else if (day.equals("5")){
    full+="-0"+day;
  }
  else if (day.equals("6")){
    full+="-0"+day;
  }
  else if (day.equals("7")){
    full+="-0"+day;
  }
  else if (day.equals("8")){
    full+="-0"+day;
  }
  else if (day.equals("9")){
    full+="-0"+day;
  }else{
  full+="-"+day;
  } //As long as day isn't single digit, it doesn't get a zero in front.
  full+="-20"+year;
  outputFile.println(full+" is the full way of printing");
}
} //end of program