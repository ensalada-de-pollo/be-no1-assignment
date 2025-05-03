package com.calculator.Lv3;

import com.calculator.Lv3.ArithmeticCalculator;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Stream;

public class App {
  public static void main(String[] args) {
    ArithmeticCalculator<Integer> int_calc = new ArithmeticCalculator<>();
    ArithmeticCalculator<Double> double_calc = new ArithmeticCalculator<>();

    Scanner sc = new Scanner(System.in);

    int cnt = 0;

    do {
      int type = 0;
      int a = 0, b = 0;
      double da = 0.0, db = 0.0;
      OperatorType op;
      double[] comp = { 0.0, 0.0 };

      try {
        System.out.print("첫 번째 숫자를 입력하세요: ");
        if (sc.hasNextInt()) {
          a = sc.nextInt();
        } else if (sc.hasNextDouble()) {
          da = sc.nextDouble();
          type = 1;
        } else {
          throw new InputMismatchException();
        }

        System.out.print("두 번째 숫자를 입력하세요: ");
        if (sc.hasNextInt()) {
          b = sc.nextInt();
        } else if (sc.hasNextDouble()) {
          db = sc.nextDouble();
          type += 10;
        } else {
          throw new InputMismatchException();
        }

        System.out.print("사칙연산 기호를 입력하세요: ");
        char temp = sc.next().charAt(0);

        switch (temp) {
          case '+' -> op = OperatorType.ADD;
          case '-' -> op = OperatorType.SUB;
          case '*' -> op = OperatorType.MUL;
          case '/' -> op = OperatorType.DIV;
          default -> throw new Exception();
        }

        switch (type) {
          case 0 -> {
            int_calc.setList(int_calc.calculate(a, b, op));
            comp[0] = (double) a;
            comp[1] = (double) b;
          }
          case 1 -> {
            double_calc.setList(double_calc.calculate(da, (double) b, op));
            comp[0] = da;
            comp[1] = (double) b;
          }
          case 10 -> {
            double_calc.setList(double_calc.calculate((double) a, db, op));
            comp[0] = (double) a;
            comp[1] = db;
          }
          case 11 -> {
            double_calc.setList(double_calc.calculate(da, db, op));
            comp[0] = da;
            comp[1] = db;
          }
        }

        if (++cnt > 3) ArithmeticCalculator.removeResult(); // 연산 결과를 담는 list의 size를 최대 3으로 유지

        System.out.print("현재 저장된 연산 결과 :");
        ArithmeticCalculator.getList()
            .forEach(n -> System.out.print(" " + n));
        System.out.println();

        System.out.println("입력 값보다 큰 저장 연산 결과:");
        ArithmeticCalculator.getList().stream()
            .filter(n -> ((Number) n).doubleValue() > comp[0] && ((Number) n).doubleValue() > comp[1])
            .forEach(System.out::println);
      } catch (ArithmeticException e) {
        System.out.println("분모에 0이 입력될 수 없습니다.");
      } catch (InputMismatchException e) {
        System.out.println("적절한 수를 입력해주세요.");
      } catch (Exception e) {
        System.out.println("잘못된 사칙연산 기호입니다.");
      }

      System.out.println("더 계산하시겠습니까? (exit 입력시 종료)");
      sc.nextLine();
    } while (!sc.nextLine().equals("exit"));
  }
}
