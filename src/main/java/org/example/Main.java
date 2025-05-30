package org.example;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.*;
import org.example.entity.*;

public class Main {

  public static void main(String[] args) throws UnsupportedEncodingException {
    Library library = new Library();
    Scanner scanner = new Scanner(System.in);

    boolean isLoop = true;
    while (isLoop) {
      Map<Integer, String> menuMap = new HashMap<>();
      menuMap.put(0, "システム終了");
      menuMap.put(1, "本を一覧表示");
      menuMap.put(2, "本を借りる");
      menuMap.put(3, "本を返す");
      menuMap.put(4, "本のタイトル検索");
      menuMap.put(5, "並び替えて表示");

      System.out.println("===================================");
      System.out.println("1. " + menuMap.get(1));
      System.out.println("2. " + menuMap.get(2));
      System.out.println("3. " + menuMap.get(3));
      System.out.println("4. " + menuMap.get(4));
      System.out.println("5. " + menuMap.get(5));
      System.out.println("0. " + menuMap.get(0));
      System.out.println("===================================");
      System.out.print("入力してください。 : ");
      String number = scanner.next();
      System.out.println("===================================");

      try {
        int n = Integer.parseInt(number);
        if (n == 0) {
          System.out.println("システムを終了します。");
          isLoop = false;
        } else if (n >= menuMap.size()) {
          System.out.println("表示されている数値の範囲内で入力してください。");
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