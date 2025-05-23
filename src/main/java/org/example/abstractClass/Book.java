package org.example.abstractClass;

public abstract class Book {
  private int id;
  private String title;
  private boolean isBorrowed;
  private String author;
  private int publishYear;

  public Book() {}

  public Book(int id, String title, String author, int publishYear){
    this.id = id;
    this.title = title;
    this.isBorrowed = true;
    this.author = author;
    this.publishYear = publishYear;
  }

  public int getId() {
    return this.id;
  }

  public String getTitle() {
    return this.title;
  }

  public String getAuthor() {
    return this.author;
  }

  public int getPublishYear() {
    return this.publishYear;
  }

  public void borrow() {
    this.isBorrowed = false;
  }

  public void returnBook() {
    this.isBorrowed = true;
  }

  public boolean isAvailable() {
    return this.isBorrowed;
  }

  public abstract void displayInfo();
}
