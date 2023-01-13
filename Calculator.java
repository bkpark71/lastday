package project1;

import java.util.Scanner;

class Add {
  private int x, y;
  public void setValue(int x, int y) {
    this.x = x;
    this.y = y;
  }
  public int calculate() {
    return x+y;
  }
}

class Mul {
  private int x, y;
  public void setValue(int x, int y) {
    this.x = x;
    this.y = y;
  }
  public int calculate() {
    return x*y;
  }
}

class Sub {
  private int x, y;
  public void setValue(int x, int y) {
    this.x = x;
    this.y = y;
  }
  public int calculate() {
    return x-y;
  }
}

class Div {
  private int x, y;
  public void setValue(int x, int y) {
    this.x = x;
    this.y = y;
  }
  public int calculate() {
    int res=0;
    try {
      res = x/y;
    }catch(ArithmeticException e) {
      System.out.print("0으로 나눌 수 없습니다.");
    }
    return res;
  }
}


public class Calculator {
  static String a, b, op;
  static int ia , ib;
  static char operator;
  public static void main (String args[])  {
    Scanner scanner = new Scanner(System.in);

    while(true) {
      System.out.println("두 정수와 연산자를 입력하시오>> 정수 연산자 정수의 순");
      //int a = scanner.nextInt();
      a = scanner.nextLine(); // isNumber?
      if(a.equals("!")) break;
      op = scanner.nextLine();
      b = scanner.nextLine();

      if(isInteger(a) && isInteger(b) && isOp(op)) {
        ia = Integer.parseInt(a);
        ib = Integer.parseInt(b);
        operator = op.charAt(0);
      }
      else {
        System.out.println("유효한 입력이 아닙니다.");
        continue;
      }

      try {
        switch (operator) {
          case '+':
            Add add = new Add();
            add.setValue(ia, ib);
            System.out.println(add.calculate());
            break;
          case '-':
            Sub sub = new Sub();
            sub.setValue(ia, ib);
            System.out.println(sub.calculate());
            break;
          case '*':
            Mul mul = new Mul();
            mul.setValue(ia, ib);
            System.out.println(mul.calculate());
            break;
          case '/':
            Div div = new Div();
            div.setValue(ia, ib);
            System.out.println(div.calculate());
            break;
          default:
            System.out.println("잘못된 연산자입니다.");
        }
      } catch (NumberFormatException e) {
        System.out.println("잘못된 형식의 피연산자입니다.");
      }
    }
    scanner.close();
  }

  public static boolean isInteger(String s) {
    boolean isInt = false;
    for(int i=0; i<s.length(); i++) {// 333* , -3
      if(Character.isDigit(s.charAt(i))) {
        isInt = true;
      }else {
        if(s.charAt(0) == '-') continue;
        else {
          isInt = false;
        }
        break;
      }
    }
    try{
      if(isInt) Integer.parseInt(s);
    }catch(NumberFormatException e){
      isInt = false;
    }
    return isInt;
  }


  public static boolean isOp(String s) {
    boolean opCheck = false;
    if (s.length() == 1 ){
      if(Character.isDigit(s.charAt(0))) {
        opCheck = false;
      }else {
        opCheck = true;
      }
    }
    else {
      opCheck = false;
    }
    return opCheck;
  }
}

