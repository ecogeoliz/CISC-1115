/* Lizbeth Martinez
 * Program #1
 * Description: This program will print a message stating my name and 
 * the phrase "this is the output of my first program." It will then
 * evaluate the formula given. A message will state "my first program is complete" 
 * once the values stop at 3.0.
 */
public class EvaluateFormula {
  public static void main (String args[]){
    System.out.println("Lizbeth Martinez. This is the output of my first program.");
    System.out.println();
    double x,y;
    for (x=-3;x<=3;x= x+0.5)
    {
      y=((4*Math.pow(x,3) + 8*Math.pow(x,2) -31*x-35))/(Math.sqrt(3*Math.pow(x,2)+1) + (2*Math.abs(x-1.5)));
      System.out.print("X = "+x+" \t");
      System.out.printf("Y = %f\t",y);

      if (y>0){
        System.out.println(" Y is positive ");}
      if(y<0) {
        System.out.println(" Y is negative ");}
      if (y==0) {
        System.out.println(" Y is zero ");}
  
    }
    System.out.println();
    System.out.println("My first program is complete");
  }
}
  
