public class EmptyNode implements IListOfStrings {

  public EmptyNode() {}

  @Override
  public boolean isEmpty() {
    return true;
  }

  @Override
  public int size() {
    return 0;
  }

  @Override
  public boolean contains(String s) {
    return false;
  }

  @Override
  public boolean containsAll(IListOfStrings other) {
    return other.isEmpty();
  }

  @Override
  public IListOfStrings filterLargerThan(int n) {
    return new EmptyNode();
  }

  @Override
  public boolean hasDuplicates() {
    return false;
  }

  @Override
  public IListOfStrings removeDuplicates() {
    return new EmptyNode();
  }
}
