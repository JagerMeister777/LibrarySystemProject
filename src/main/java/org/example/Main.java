package org.example;

import java.util.*;
import org.example.entity.*;

public class Main {

  public static void main(String[] args) {
    Library library = new Library();
    Scanner scanner = new Scanner(System.in);

    boolean isLoop = true;
    while (isLoop) {
      System.out.println("===================================");
      System.out.println("1. 本を一覧表示");
      System.out.println("2. 本を借りる");
      System.out.println("3. 本を返す");
      System.out.println("4. 終了");
      System.out.println("===================================");
      System.out.print("入力してください。 : ");
      String number = scanner.next();
      System.out.println("===================================");

      try {
        int n = Integer.parseInt(number);
        if (n == 4) {
          System.out.println("システムを終了します。");
          isLoop = false;
        } else if (n >= 4) {
          System.out.println("１～４の数値で入力してください。");
        } else {
          library.reception(n, scanner);
        }
      } catch (NumberFormatException e) {
        System.out.println("数字以外の値が入力されました。");
        System.out.println("もう一度入力して下さい。");
      } 
    }
    scanner.close();
  }
}