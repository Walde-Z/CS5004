package main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class BookTest {
  private Book wind;

  @org.junit.jupiter.api.BeforeEach
  void setUp() {
    this.wind = new Book( "Gone with the Wind", "1362",
        "Margaret Mitchell");
  }

  @org.junit.jupiter.api.Test
  void getTitle() {
    Assertions.assertEquals("Gone with the Wind", this.wind.getTitle());
  }

  @org.junit.jupiter.api.Test
  void getPage() {
    Assertions.assertEquals("1362", this.wind.getPage());
  }

  @org.junit.jupiter.api.Test
  void getAuthor() {
    Assertions.assertEquals("Margaret Mitchell", this.wind.getAuthor());
  }
}