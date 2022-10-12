package fracCalc;
import java.util.*;
public class FracCalc {
    public static void main(String[] args){
     System.out.println("Input(or enter quit to stop): ");
     Scanner input = new Scanner(System.in);
       String frac = input.nextLine();
       System.out.println(produceAnswer(frac));
      while (!frac.equals("quit")) {
      System.out.println("Input(or enter quit to stop): ");
      frac = input.nextLine();
      produceAnswer(frac);
    } 
  }
 
 public static String produceAnswer(String frac){
    int s = frac.indexOf(" ");
    int count = 0;
    String frac1 = "";
    String frac2 = "";
    String answer = "";
    for (int i=1; i<frac.length(); i++){
      if(frac.substring(i-1, i).equals(" ")){
        count++;
      }
    }
    for (int i = 0; i<count/2; i++){
      s = frac.indexOf(" ");
      String op = frac.substring(s + 1, s+ 2);
      s = frac.indexOf(" ");
      if (s == -1){
        frac1 = frac;
      }
      else{
        frac1 = frac.substring(0, s);
      }
      frac = frac.substring(s + 3);
      s = frac.indexOf(" ");
      if (s == -1){
        frac2 = frac;
      }
      else{
        frac2 = frac.substring(0, s);
      }
      if (i == (count/2)-1){
        frac = "";
      }else {
      frac = frac.substring(s);
      }
      answer = allFrac(frac1, frac2, frac, op);
      answer = reduceFrac(answer);
      System.out.print(frac1 + " " + op + " ");
      frac = answer + frac;
    }
    System.out.println( frac2 +  " = " + frac);
    return frac;
  }

public static String makeImp(String frac){
  int und = frac.indexOf("_");
  int sl = frac.indexOf("/");
  int whole = Integer.parseInt(frac.substring(0, und));
  int num = Integer.parseInt(frac.substring(und + 1, sl));
  int den = Integer.parseInt(frac.substring(sl + 1));
    num = (Math.abs(whole) * den) + num;
      if (frac.contains("-")){
        num = - 1 * num;
      }
    frac = "" + num + "/" + den;
    return frac;
  }

  public static String allFrac(String frac1, String frac2, String frac, String op){ 
    if (frac1.contains("_")){
      frac1 = makeImp(frac1);
    } else if (!frac1.contains("/")){
      frac1 += "/1";
    }
    if (frac2.contains("_")){
      frac2 = makeImp(frac2);
    } else if (!frac2.contains("/")){
      frac2 += "/1";
    }
      frac = calcA(frac1, frac2, op);
    return frac;
  }
  
  public static int calcN(int den, String frac, int x, int y){ 
    String num = "0";
    num = frac.substring(x + 1, y);
    int numA = Integer.parseInt(num) * den;
    return numA;
  }

  public static String calcA(String frac1, String frac2, String op){ 
    int x1 = frac1.indexOf("_");
    int y1 = frac1.indexOf("/");
    int x2 = frac2.indexOf("_");
    int y2 = frac2.indexOf("/");
    int den1 = Integer.parseInt(frac1.substring(y1 + 1));
    int den2 = Integer.parseInt(frac2.substring(y2 + 1));
    int denCo = den1 * den2;  
    int num1 = calcN(den2, frac1, x1, y1);
    int num2 = calcN(den1, frac2, x2, y2);
    int numW = 0;
    if (op.equals("+")){
      numW = num1 + num2;
    } else if (op.equals("-")){
      numW = num1 - num2;
    } else if (op.equals("*")){
      numW = (num1 * num2) / denCo; 
    } else if (op.equals("/")){
      numW = num1 * (den2 * den1);
      denCo = num2 * denCo;
    }
      
    return "" + numW + "/" + denCo;
  }

   public static int findGCD(int n1, int n2) {
    if (n2 == 0) {
      return n1;
    }
    return findGCD(n2, n1 % n2);
  }

public static String reduceFrac( String frac) {
    String fin = "";
    int und = frac.indexOf("_");
    int sl = frac.indexOf("/");
    int whole = 0;
    int num = Integer.parseInt(frac.substring(und + 1, sl));
    int den = Integer.parseInt(frac.substring(sl + 1));
    int findGCD = findGCD(num, den);
    if (den < 0 && num < 0){
      num = Math.abs(num);
      den = Math.abs(den);
    } else if (num < 0){
      num = Math.abs(num);
        fin = "-";
    } else if (den < 0){
      den = Math.abs(den);
        fin = "-";
    } if (den != 1){
      for (int i = den; i >= 2; i--){
        if (num % i == 0 && den % i == 0){
            num = Math.abs(num/findGCD);
            den = Math.abs(den/findGCD);
          }
      } if (Math.abs(num) > Math.abs(den)){
        whole += num / den;
        num = num % den;
      }
    } if (whole == 0 ){
      if (den == 1){
        if (num == 0){
          fin = "0";
        } else{  fin += num;
      }
      } else { fin += num + "/" + den;
      }
    } else if (whole != 0){
      if (den == 1){
        fin += whole;
      } else { fin += whole + "_" + num + "/" + den;
      }
    }
    return fin;
    }
 }