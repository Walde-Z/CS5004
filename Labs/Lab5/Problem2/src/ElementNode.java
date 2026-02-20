public class ElementNode implements IListOfStrings{
  private String data;
  private IListOfStrings rest;

  public ElementNode(String data, IListOfStrings rest) {
    this.data = data;
    this.rest = rest;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }

  @Override
  public int size() {
    return 1 + rest.size();
  }

  @Override
  public boolean contains(String s) {
    if (this.data.equals(s)) {
      return true;
    }
    else {
      return this.rest.contains(s);
    }
  }

  @Override
  public boolean containsAll(IListOfStrings other) {
    if (other.isEmpty()) {
      return true;
    }
    if (other instanceof ElementNode) {
      ElementNode otherNode = (ElementNode) other;
      return this.contains(otherNode.data) && this.containsAll(otherNode.rest);
    }
    return true;
  }

  @Override
  public IListOfStrings filterLargerThan(int n) {
    if (this.data.length() > n) {
      return this.rest.filterLargerThan(n);
    }
    else {
      return new ElementNode(this.data, this.rest.filterLargerThan(n));
    }
  }

  @Override
  public boolean hasDuplicates() {
    if (this.rest.contains(this.data)) {
      return true;
    } else {
      return this.rest.hasDuplicates();
    }
  }

  @Override
  public IListOfStrings removeDuplicates() {
      IListOfStrings restWithoutDuplicates = this.rest.removeDuplicates();

      if (restWithoutDuplicates.contains(this.data)) {
        return restWithoutDuplicates;
      }
      else {
        return new ElementNode(this.data, restWithoutDuplicates);
      }
  }
}
