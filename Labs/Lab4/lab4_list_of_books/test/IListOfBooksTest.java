import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IListOfBooksTest {

  Book book1 = new Book("book1", "A", 1999, 13.4f);
  Book book2 = new Book("book2", "B", 2000, 25.6f);
  Book book3 = new Book("book3", "C", 2001, 37.8f);

  @Test
  public void testEmptyNodeCount1() {
    IListOfBooks empty = new EmptyNode();
    assertEquals(0, empty.count());
  }

  @Test
  public void testEmptyNodeCount2() {
    IListOfBooks empty = new EmptyNode();
    assertTrue(empty.count() == 0);
  }

  @Test
  public void testElementNodeCount1() {
    IListOfBooks list = new ElementNode(book1, new EmptyNode());
    assertEquals(1, list.count());
  }

  @Test
  public void testElementNodeCount2() {
    IListOfBooks list = new ElementNode(book1,
                        new ElementNode(book2,
                        new ElementNode(book3,
                        new EmptyNode())));
    assertEquals(3, list.count());
  }

  @Test
  void testEmptyNodeTotalPrice1() {
    IListOfBooks empty = new EmptyNode();
    assertEquals(0.0f, empty.totalPrice());
  }

  @Test
  void testEmptyNodeTotalPrice2() {
    IListOfBooks empty = new EmptyNode();
    assertTrue(empty.totalPrice() == 0.0f);
  }

  @Test
  void testElementNodeTotalPrice1() {
    IListOfBooks list = new ElementNode(book1, new EmptyNode());
    assertEquals(13.4f, list.totalPrice());
  }

  @Test
  void testElementNodeTotalPrice2() {
    IListOfBooks list = new ElementNode(book1,
                        new ElementNode(book2,
                        new ElementNode(book3,
                        new EmptyNode())));
    assertEquals(76.8f, list.totalPrice());
  }

  @Test
  void testEmptyNodeAllBefore1() {
    IListOfBooks empty = new EmptyNode();
    IListOfBooks result = empty.allBefore(2000);
    assertEquals(0, result.count());
    assertInstanceOf(EmptyNode.class, result);
  }

  @Test
  void testEmptyNodeAllBefore2() {
    IListOfBooks empty = new EmptyNode();
    IListOfBooks result = empty.allBefore(3000);
    assertTrue(result.count() == 0);
    assertInstanceOf(EmptyNode.class, result);
  }

  @Test
  void testElementNodeAllBefore1() {
    IListOfBooks list = new ElementNode(book1,
                        new ElementNode(book2,
                        new ElementNode(book3,
                        new EmptyNode())));
    IListOfBooks result = list.allBefore(2000);
    assertEquals(1, result.count());
  }

  @Test
  void testElementNodeAllBefore2() {
    IListOfBooks list = new ElementNode(book1,
                        new ElementNode(book2,
                        new ElementNode(book3,
                        new EmptyNode())));
    IListOfBooks result = list.allBefore(3000);
    assertEquals(3, result.count());
  }

  @Test
  void testEmptyNodeAddAtEnd1() {
    IListOfBooks empty = new EmptyNode();
    IListOfBooks result = empty.addAtEnd(book1);
    assertEquals(1, result.count());
  }

  @Test
  void testEmptyNodeAddAtEnd2() {
    IListOfBooks empty = new EmptyNode();
    IListOfBooks result = empty.addAtEnd(book1);
    assertEquals(13.4f, result.totalPrice());
  }

  @Test
  void testElementNodeAddAtEnd1() {
    IListOfBooks list = new ElementNode(book2,
                        new ElementNode(book3,
                        new EmptyNode()));
    IListOfBooks result = list.addAtEnd(book1);
    assertEquals(3, result.count());
  }

  @Test
  void testElementNodeAddAtEnd2() {
    IListOfBooks list = new ElementNode(book2,
                        new ElementNode(book3,
                        new EmptyNode()));
    IListOfBooks result = list.addAtEnd(book1);
    assertEquals(76.8f, result.totalPrice(), 0.01f);
  }

  @Test
  void testEmptyNodeToString1() {
    IListOfBooks empty = new EmptyNode();
    assertEquals("", empty.toString());
  }

  @Test
  void testEmptyNodeToString2() {
    IListOfBooks empty = new EmptyNode();
    assertEquals(0, empty.toString().length());
  }

  @Test
  void testElementNodeToString1() {
    IListOfBooks list = new ElementNode(book1,
                        new ElementNode(book2,
                        new ElementNode(book3,
                        new EmptyNode())));
    String result = list.toString();
    assertTrue(result.contains("book1"));
    assertTrue(result.contains("B"));
    assertTrue(result.contains("2001"));
  }

  @Test
  void testElementNodeToString2() {
    IListOfBooks list = new ElementNode(book1, new EmptyNode());
    String result = list.toString();
    assertTrue(result.contains("book1"));
    assertTrue(result.contains("A"));
  }
}