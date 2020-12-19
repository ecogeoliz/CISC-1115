/* Lizbeth Martinez
 * Program #4
 * Description: The main program will read in a group of 3 integer values which represent SAT scores. 
 * The main program will call a method to determine if these 3 sources are all valid-
 * valid being within the range of 200 to 800, including both end points, and is a multiple of 10 (ends in 0).
 * If the scores are all valid, the main program will call a method (which itself calls other methods)
 * to classify the group of 3 scores in various ways.
 * The main program will repeat this process for the entire set of data, then print some counters.
 * To detect end of data, either a trailer method, using a special combination of data values as a trailer, 
 * or the user response method ("Do you want to continue?") will be used.
 */
import java.io.*;
import java.util.Scanner;

public class SATScores {
  public static void main(String[] args) throws IOException {
    PrintWriter outputFile = new PrintWriter("4output.txt");
    Scanner keyboard = new Scanner(System.in);
    int score1,score2,score3; 
    int total=0;
    int valids=0, invalids=0;
    char answer;
    do{ 
      total++; //adds to counter of total groups
      System.out.println("Enter an SAT score");
      score1=keyboard.nextInt();
      System.out.println("Enter an SAT score");
      score2=keyboard.nextInt();
      System.out.println("Enter an SAT score");
      score3=keyboard.nextInt();
      outputFile.println("Scores:"+score1+" "+score2+" "+score3);
      if (isitavalidgroup(score1,score2,score3,outputFile)){
       outputFile.println("Group is valid");
       classify(score1,score2,score3,outputFile);
       valids++; //adds to counter of valid groups
      }else{
        outputFile.println("Group is invalid");
        invalids++; //adds to counter of invalid groups
      }
      outputFile.println();
      System.out.println("Type Y to continue; N to stop:");
      String myline=keyboard.next(); //tutor helped explained how a String works 
      answer=myline.charAt(0);
    } while (answer == 'Y'); 
    outputFile.println("Total number of groups: "+total+" Valids: "+valids+" Invalids: "+invalids); 
// final value of all three counters printed
      
keyboard.close();
outputFile.close();

  } //end of main program
  
  /* method classify
   * Input: score1, score2, score3, total, PrintWriter outputFile
   * Process: classify calls to rateonescore, findtotalscore, and ratethegroup.
   * rateonescore ranks each score one at a time. findtotalscore finds the total of score1,score2, and score3.
   * ratethegroup uses the results of rateonescore and findtotalscore together to rate the group.
   * Output: classify returns what it gathered to the main program.
   */
  public static void classify(int score1,int score2,int score3,PrintWriter outputFile){
    rateonescore(score1,outputFile);
    rateonescore(score2,outputFile);
    rateonescore(score3,outputFile);
    
    int total=findtotalscore(score1,score2,score3,outputFile); //assigning variable total here
    
    ratethegroup(score1,score2,score3,total,outputFile);
  }
  /*method findtotalscore
   *Input: score1,score2,score3, PrintWriter outputFile
   *Process: findtotalscore receives score1,score2,and score3. 
   *findtotalscore determines the total by taking the sum of the 3 scores.
   *findtotalscore returns the sum and it is printed in the outputFile.
   *Output: Total score: ___ Insert calculated sum here
   */
  public static int findtotalscore(int score1,int score2,int score3,PrintWriter outputFile){
    int total=0;
    total=score1+score2+score3;
    outputFile.println("Total score: "+total);
    return total;
  }
  /*method rateonescore
   *Input: validscore, PrintWriter outputFile
   *Process: rateonescore receives the validscore. Determines which of the following 3 categories the score is in: 
   *less than 500, more than 500 but less than 800, or 800 (perfect score). 
   *Output: rateonescore prints a message indicating which of these 3 categories occurred.
   */
    public static void rateonescore(int validscore,PrintWriter outputFile){
     outputFile.print(validscore+": ");
     if(validscore<500)
     outputFile.println("Below 500");
     else if (validscore>500 && validscore<800)
     outputFile.println("More than 500 but less than 800");
     else if (validscore==800)
     outputFile.println("Perfect score");
  }
  /*method ratethegroup
   *Input: score1, score2, score3, total, PrintWriter outputFile
   *Process: Using the 3 scores and their total, ratethegroup determines their status as follows:
   *Grouped by total is 2100 or above
   * outstanding - total score is 2100 or above AND score on each part is 700 or above
   * very good - total score is 2100 or above AND 2 of the scores are 700 or above 
   * lop-sided - total score is 2100 or above AND 1 score is 700 or above
   *NOT Grouped by total is 2100 or above
   * weak - if total score is less than 2100 AND no individual score is 500 or above
   * erratic - if no condition described above is true
   *Regardless of whether the scores are grouped by total is 2100 or above, ratethegroup prints the group status.
   *Output: Group is ___ Insert group status determined by ratethegroup
   */
    public static void ratethegroup(int score1,int score2,int score3,int total,PrintWriter outputFile){
      if (total>=2100){
      if(score1>=700 && score2>=700 && score3>=700)
      outputFile.println("Group is outstanding");
      else if ((score1>=700 && score2>=700)||(score1>=700 && score3>=700)||(score2>=700 && score3>=700))
      outputFile.println("Group is very good");
      else if (score1>=700 || score2>=700 || score3>=700)
      outputFile.println("Group is lop-sided");
    }
    else if (score1<=500 && score2<=500 && score3<=500)
      outputFile.println("Group is weak");
    else {
      outputFile.println("Group is erratic");
      }
    }

  /*method isitavalidgroup
   *Input: score1,score2,score3,PrintWriter outputFile
   *Process: isitavalidgroup determines if score1, score2, and score3 are valid. 
   *Valid is when the score ranges from 200 to 800 AND is a multiple of 10 (ends in 0).
   *If valid, isitavalidgroup goes to main program 
   *which will print a message, add to the counter of valid groups, and call method classify.
   *If invalid, isitavalidgroup goes to main program
   *which will print a message, add to the counter of invalid groups, and go back to read the next group of scores.
   *isitavalidgroup will return true of all 3 values are valid, otherwise it will return false.
   *Output: If invalid.
   *Invalid score:
   *        If valid,
   *Prints the corresponding statements within classify
   */
  public static boolean isitavalidgroup(int score1,int score2,int score3,PrintWriter outputFile){
    boolean result1=true;
    boolean result2=true;
    boolean result3=true;
    if (score1<200 ||score1>800 ||score1%10!=0) {
    outputFile.println("Invalid score: "+score1);
    result1=false;
    }
    if (score2<200 ||score2>800 ||score2%10!=0) {
    outputFile.println("Invalid score: "+score2);
    result2=false;
    }
    if (score3<200 ||score3>800 ||score3%10!=0) {
    outputFile.println("Invalid score: "+score3);
    result3=false;
    }
    if (result1==false||result2==false||result3==false)
    return false;
    return true;
  }
} //end of assignment 4