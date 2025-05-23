package org.example.entity;

import org.example.abstractClass.Book;

public class PrintedBook extends Book{
  private final String isbn;
  private final int pages;
  private final String shelfLocation;

  public PrintedBook(int id, String title, String isbn, int pages, String shelfLocation) {
    super(id,title);
    this.isbn = isbn;
    this.pages = pages;
    this.shelfLocation = shelfLocation;
  }

  @Override
  public void displayInfo() {
    String status = isAvailable() ? "貸出可" : "貸出中";
    System.out.println(super.getId() + " | " + super.getTitle() + " | " + isbn + " | " + pages + " | " + shelfLocation + " | " + status);
  }
}
