import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IListOfStringsTest {

  @Test
  void testEmptyNodeIsEmpty() {
    IListOfStrings empty = new EmptyNode();
    assertTrue(empty.isEmpty());
  }

  @Test
  void testElementNodeIsEmpty() {
    IListOfStrings list = new ElementNode("hello", new EmptyNode());
    assertFalse(list.isEmpty());
  }

  @Test
  void testEmptyNodeSize() {
    IListOfStrings empty = new EmptyNode();
    assertEquals(0, empty.size());
  }

  @Test
  void testSingleElementNodeSize() {
    IListOfStrings list = new ElementNode("hello", new EmptyNode());
    assertEquals(1, list.size());
  }

  @Test
  void testMultipleElementNodeSize() {
    IListOfStrings list = new ElementNode("A",
                       new ElementNode("B",
                       new ElementNode("C",
                       new EmptyNode())));
    assertEquals(3, list.size());
  }

  @Test
  void testEmptyNodeContains() {
    IListOfStrings empty = new EmptyNode();
    assertFalse(empty.contains("hello"));
  }

  @Test
  void testElementNodeContains() {
    IListOfStrings list = new ElementNode("hello", new EmptyNode());
    assertTrue(list.contains("hello"));
  }

  @Test
  void testElementNodeNotContains() {
    IListOfStrings list = new ElementNode("hello", new EmptyNode());
    assertFalse(list.contains("hi"));
  }

  @Test
  void testEmptyNodeContainsAll() {
    IListOfStrings empty = new EmptyNode();
    IListOfStrings other = new EmptyNode();
    assertTrue(empty.containsAll(other));
  }

  @Test
  void testElementNodeContainsAll() {
    IListOfStrings list = new ElementNode("hello", new ElementNode("hi", new EmptyNode()));
    IListOfStrings other = new ElementNode("hello", new EmptyNode());

    assertTrue(list.containsAll(other));
  }

  @Test
  void testElementNodeNotContainsAll() {
    IListOfStrings list = new ElementNode("hello", new ElementNode("hi", new EmptyNode()));
    IListOfStrings other = new ElementNode("hello", new ElementNode("bye", new EmptyNode()));

    assertFalse(list.containsAll(other));
  }

  @Test
  void testEmptyNodeFilterLargerThan() {
    IListOfStrings empty = new EmptyNode();
    assertTrue(empty.filterLargerThan(5).isEmpty());
  }

  @Test
  void testElementNodeFilterLargerThanSome() {
    IListOfStrings list = new ElementNode("hello",
                          new ElementNode("hi",
                          new ElementNode("bye",
                          new EmptyNode())));
    IListOfStrings result = list.filterLargerThan(3);
    assertEquals(2, result.size());
    assertTrue(result.contains("bye"));
    assertTrue(result.contains("hi"));
  }

  @Test
  void testElementNodeFilterLargerThanAll() {
    IListOfStrings list = new ElementNode("hello",
                          new ElementNode("hi",
                          new ElementNode("bye",
                          new EmptyNode())));
    IListOfStrings result = list.filterLargerThan(1);
    assertTrue(result.isEmpty());
  }

  @Test
  void testEmptyNodeHasDuplicates() {
    IListOfStrings empty = new EmptyNode();
    assertFalse(empty.hasDuplicates());
  }

  @Test
  void testElementNodeHasDuplicates() {
    IListOfStrings list = new ElementNode("hello",
                          new ElementNode("hello",
                          new ElementNode("bye",
                          new EmptyNode())));
    assertTrue(list.hasDuplicates());
  }

  @Test
  void testElementNodeNotHasDuplicates() {
    IListOfStrings list = new ElementNode("hello",
                          new ElementNode("hi",
                          new ElementNode("bye",
                          new EmptyNode())));
    assertFalse(list.hasDuplicates());
  }

  @Test
  void testEmptyNodeRemoveDuplicates() {
    IListOfStrings empty = new EmptyNode();
    assertTrue(empty.removeDuplicates().isEmpty());
  }

  @Test
  void testElementNodeRemoveDuplicates() {
    IListOfStrings list = new ElementNode("hello",
                          new ElementNode("hello",
                          new ElementNode("bye",
                          new EmptyNode())));
    IListOfStrings result = new ElementNode("hello",
                            new ElementNode("bye",
                            new EmptyNode()));
    assertEquals(result.size(), 2);
    assertTrue(result.contains("hello"));
    assertTrue(result.contains("bye"));
  }

  @Test
  void testEmptyNodeNotRemoveDuplicates() {
    IListOfStrings list = new ElementNode("hello",
                          new ElementNode("hi",
                          new ElementNode("bye",
                          new EmptyNode())));
    IListOfStrings result = list.removeDuplicates();
    assertEquals(result.size(), 3);
    assertTrue(result.contains("hello"));
    assertTrue(result.contains("hi"));
    assertTrue(result.contains("bye"));
  }
}