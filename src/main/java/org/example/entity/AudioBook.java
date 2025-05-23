package org.example.entity;

import org.example.abstractClass.Book;

public class AudioBook extends Book{
  private final String narrator;
  private final int durationMin;

  public AudioBook(int id,String title, String narrator, int durationMin) {
    super(id,title);
    this.narrator = narrator;
    this.durationMin = durationMin;
  }

  @Override
  public void displayInfo() {
    String status = isAvailable() ? "貸出可" : "貸出中";
    System.out.println(super.getId() + " | " + super.getTitle() + " | " + narrator + " | " + durationMin + " | " + status );
  }
}
