package com.calculator.Lv3;

import java.util.ArrayList;

public class ArithmeticCalculator<T> {
  private static final ArrayList<Object> list; // 객체가 여러 번 만들어질 필요가 없으므로 final로 선언

  static {
    list = new ArrayList<>();
  }

  public T calculate(T a, T b, OperatorType op) throws ArithmeticException, Exception {
    if (a instanceof Double) {
      double x = (Double) a;
      double y = (Double) b;
      return switch (op) {
        case ADD -> (T) Double.valueOf(x + y);
        case SUB -> (T) Double.valueOf(x - y);
        case MUL -> (T) Double.valueOf(x * y);
        case DIV -> {
          if (Double.compare(y, 0.0) == 0) throw new ArithmeticException();
          yield (T) Double.valueOf(x / y);
        }
        default -> throw new Exception();
      };
    } else if (a instanceof Integer) {
      int x = (Integer) a;
      int y = (Integer) b;
      return switch (op) {
        case ADD -> (T) Integer.valueOf(x + y);
        case SUB -> (T) Integer.valueOf(x - y);
        case MUL -> (T) Integer.valueOf(x * y);
        case DIV -> (T) Integer.valueOf(x / y);
        default -> throw new Exception();
      };
    }
    throw new Exception();
  }

  public static ArrayList<Object> getList() {
    return new ArrayList<>(list); // list 객체를 그대로 반환해버리면 캡슐화가 무의미해지므로 복사본 반환
  }

  public void setList(T result) {
    list.add(result);
  }

  public static void removeResult() {
    list.remove(0);
  }
}
