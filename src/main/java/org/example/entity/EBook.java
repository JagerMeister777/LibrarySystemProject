package org.example.entity;

import org.example.abstractClass.Book;

public class EBook extends Book{
  private final String fileUrl;
  private final String format;

  public EBook(int id, String title,String fileUrl, String format) {
    super(id,title);
    this.fileUrl = fileUrl;
    this.format = format;
  }

  @Override
  public void displayInfo() {
    String status = isAvailable() ? "貸出可" : "貸出中";
    System.out.println(super.getId() + " | " + super.getTitle() + " | " + format + " | " + status + " | " + fileUrl);
  }

}
