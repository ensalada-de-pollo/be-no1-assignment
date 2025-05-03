package com.calculator.Lv1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String temp = "";
    int A = 0;
    int B = 0;
    char op = ' ';
    int result = 0;

    do {
      try {
        System.out.print("첫 번째 숫자를 입력하세요: ");
        A = sc.nextInt();

        System.out.print("두 번째 숫자를 입력하세요: ");
        B = sc.nextInt();

        System.out.print("사칙연산 기호를 입력하세요: ");
        op = sc.next().charAt(0);

        result = switch (op) {
          case '+' -> A + B;
          case '-' -> A - B;
          case '*' -> A * B;
          case '/' -> A / B;
          default -> throw new Exception();
        };
        System.out.println("결과: " + result);
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
