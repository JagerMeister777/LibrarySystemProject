package org.example.abstractClass;

public abstract class Book {
  private int id;
  private String title;
  private boolean isBorrowed;

  public Book() {}

  public Book(int id, String title){
    this.id = id;
    this.title = title;
    this.isBorrowed = true;
  }

  public int getId() {
    return this.id;
  }

  public String getTitle() {
    return this.title;
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
