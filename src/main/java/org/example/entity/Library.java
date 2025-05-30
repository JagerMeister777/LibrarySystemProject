package org.example.entity;

import java.util.*;
import org.example.abstractClass.Book;

public class Library {
  private List<Book> books;

  public Library() {
    List<Book> initBooks = new ArrayList<>();
    initBooks.add(new PrintedBook(1, "Javaの基本", "田中一郎", 2018, "978-4-123-45678-9", 320, "A-1"));
    initBooks.add(new PrintedBook(2, "オブジェクト指向入門", "鈴木二郎", 2019, "978-4-987-65432-1", 280, "B-2"));

    initBooks.add(new EBook(3, "Effective Java", "Joshua Bloch", 2017, "https://example.com/ejava", "PDF"));
    initBooks.add(new EBook(4, "Java Silver対策集", "佐々木三郎", 2020, "https://example.com/silver", "EPUB"));

    initBooks.add(new AudioBook(5, "思考は現実化する", "山田太郎", 2021, "anonimas",45));
    initBooks.add(new AudioBook(6, "7つの習慣", "佐藤花子", 2022, "anonimas", 90));

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

    public List<Book> findBookByTitle (String title) {
      List<Book> bookList = new ArrayList<>();
    for (Book book : books) {
      String targetTitle = book.getTitle();
      if (targetTitle.equals(title) || targetTitle.contains(title)) {
        bookList.add(book);
      }
    }
    return bookList;
  }

  public void listAllBook() {
    for (Book book : books) {
      book.displayInfo();
    }
  }

  public String borrow(int id) throws NullPointerException {
    Book book = findBookById(id);
      if (book.isAvailable()) {
        book.borrow();
        return book.getTitle() + " を借りました。";
      } else {
        return book.getTitle() + " は借りられています。";
      }
  }

  public String release(int id) throws NullPointerException {
    Book book = findBookById(id);
    try {
      if (book.isAvailable()) {
        return book.getTitle() + " は貸し出されていません。";
      } else {
        book.returnBook();
        return book.getTitle() + " を返却しました。";
      }
    } catch (NullPointerException e) {
      return "選択したIDの本が存在しませんでした。 ID: " + id;
    }
  }

  public void reception (int number, Scanner scanner) {
    try {
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
          System.out.println(release(Integer.parseInt(scanner.next())));
          break;
        }
        case 4: {
          System.out.print("検索する本のタイトルを入力してください。 : ");
          List<Book> resultList = findBookByTitle(scanner.next());
          System.out.println("検索結果 : " + resultList.size() + "件");
          resultList.forEach(book -> {
            book.displayInfo();
          });
          break;
        }
        case 5: {
          System.out.println("どの順番で並び替えますか？");
          System.out.println("1. タイトル順");
          System.out.println("2. 著名順");
          System.out.println("3. 発行年順");
          System.out.println("===================================");
          System.out.print("入力 : ");
            switch (Integer.parseInt(scanner.next())) {
              case 1: {
                this.books.sort(Comparator.comparing(Book::getTitle));
                listAllBook();
                System.out.println("タイトル順で並び替えました。");
                break;
              }
              case 2: {
                this.books.sort(Comparator.comparing(Book::getAuthor));
                listAllBook();
                System.out.println("著者名順で並び替えました。");
                break;
              }
              case 3: {
                this.books.sort(Comparator.comparing(Book::getPublishYear).reversed());
                listAllBook();
                System.out.println("発行年順で並び替えました。");
                break;
              } 
            }
        }
      }
    } catch (NullPointerException e) {
      System.out.println("本がありませんでした。");
    } catch (NumberFormatException e) {
      System.out.println("正しい数値ではありませんでした。");
    }
  }
}
