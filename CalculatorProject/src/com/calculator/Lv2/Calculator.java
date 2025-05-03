package com.calculator.Lv2;

import java.util.ArrayList;

public class Calculator {
  private final ArrayList<Integer> list; // 객체가 여러 번 만들어질 필요가 없으므로 final로 선언

  public Calculator() {
    list = new ArrayList<>();
  }

  public int calculate(int a, int b, char op) throws ArithmeticException, Exception {
    return switch (op) {
      case '+' -> a + b;
      case '-' -> a - b;
      case '*' -> a * b;
      case '/' -> a / b;
      default -> throw new Exception();
    };
  }

  public ArrayList<Integer> getList() {
    return new ArrayList<>(list); // list 객체를 그대로 반환해버리면 캡슐화가 무의미해지므로 복사본 반환
  }

  public void setList(int result) {
    list.add(result);
  }

  public void removeResult() {
    list.remove(0);
  }
}
