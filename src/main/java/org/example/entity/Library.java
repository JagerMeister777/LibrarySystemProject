package org.example.entity;

import java.util.*;
import org.example.abstractClass.Book;

public class Library {
  private List<Book> books;

  public Library() {
    List<Book> initBooks = new ArrayList<>();
    initBooks.add(new PrintedBook(1, "Javaの基本", "978-4-123-45678-9", 320, "A-1"));
    initBooks.add(new PrintedBook(2, "オブジェクト指向入門", "978-4-987-65432-1", 280, "B-2"));

    initBooks.add(new EBook(3, "Effective Java", "https://example.com/ejava", "PDF"));
    initBooks.add(new EBook(4, "Java Silver対策集", "https://example.com/silver", "EPUB"));

    initBooks.add(new AudioBook(5, "思考は現実化する", "山田太郎", 45));
    initBooks.add(new AudioBook(6, "7つの習慣", "佐藤花子", 90));

    this.books = initBooks;
  }

  public Book findBookById (int id) {
    for (Book book : books) {
      if (book.getId() == id) {
        return book;
      }
    }
    return null;
  }

  public void listAllBook() {
    for (Book book : books) {
      book.displayInfo();
    }
  }

  public String borrow(int id) {
    for (Book book : books) {
      if (book.getId() == id && book.isAvailable()) {
        book.borrow();
        return book.getTitle() + "を借りました。";
      } else if(!book.isAvailable()) {
        return book.getTitle() + "は借りられています。";
      }
    }
    return "選択したIDの本が存在しませんでした。 ID: " + id;
  }

  public String returnBook(int id) {
    for (Book book : books) {
      if (book.getId() == id && !book.isAvailable()) {
        book.returnBook();
        return book.getTitle() + "を返却しました。";
      }
    }
    return "選択したIDの本が存在しませんでした。 ID: " + id;
  }

  public void reception (int number, Scanner scanner) {
    switch (number) {
      case 1: {
        System.out.println("本の一覧表示をします。");
        listAllBook();
        break;
      }
      case 2: {
        System.out.print("借りたい本のIDを入力してください。 : ");
        System.out.println(borrow(Integer.parseInt(scanner.next())));
        break;
      }
      case 3: {
        System.out.print("返却する本のIDを入力してください。 : ");
        System.out.println(returnBook(Integer.parseInt(scanner.next())));
        break;
      }
    }
  }
}
