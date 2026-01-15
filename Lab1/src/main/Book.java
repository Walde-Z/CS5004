package main;

public class Book {
  private String title;
  private String page;
  private String author;
  /**
   Creates a new book given the book's title, page and author as strings.
   * @param title the book's title
   * @param page the book's page
   * @param author the book’s author
   */
  public Book(String title, String page, String author) {
    this.title = title;
    this.page = page;
    this.author = author; }
  /**
   * @return the title
   */
  public String getTitle() { return this.title; }
  /**
   * @return the page
   */
  public String getPage() { return this.page; }
  /**
   * @return the author
   */
  public String getAuthor() {return this.author; }
}