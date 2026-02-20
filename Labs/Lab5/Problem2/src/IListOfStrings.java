public interface IListOfStrings {

  boolean isEmpty();
  int size();
  boolean contains(String s);
  boolean containsAll(IListOfStrings other);
  IListOfStrings filterLargerThan(int n);
  boolean hasDuplicates();
  IListOfStrings removeDuplicates();
}