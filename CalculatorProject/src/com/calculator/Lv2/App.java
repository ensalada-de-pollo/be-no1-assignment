package com.calculator.Lv2;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Stream;

public class App {
  public static void main(String[] args) {
    Calculator calc = new Calculator();
    Scanner sc = new Scanner(System.in);

    int cnt = 0;

    do {
      try {
        System.out.print("첫 번째 숫자를 입력하세요: ");
        int a = sc.nextInt();

        System.out.print("두 번째 숫자를 입력하세요: ");
        int b = sc.nextInt();

        System.out.print("사칙연산 기호를 입력하세요: ");
        char op = sc.next().charAt(0);

        calc.setList(calc.calculate(a, b, op));

        if (++cnt > 3) calc.removeResult(); // 연산 결과를 담는 list의 size를 최대 3으로 유지
      } catch (ArithmeticException e) {
        System.out.println("분모에 0이 입력될 수 없습니다.");
      } catch (InputMismatchException e) {
        System.out.println("적절한 수를 입력해주세요.");
      } catch (Exception e) {
        System.out.println("잘못된 사칙연산 기호입니다.");
      }

      System.out.print("현재 저장된 연산 결과:");
      calc.getList()
          .forEach(n -> System.out.print(" " + n));
      System.out.println();

      System.out.println("더 계산하시겠습니까? (exit 입력시 종료)");
      sc.nextLine();
    } while (!sc.nextLine().equals("exit"));
  }
}
