import java.util.Iterator;
import java.util.List;

public class SwimmersIterator implements Iterator<Swimmer> {
  private List<Swimmer> swimmers;
  private int index;

  public SwimmersIterator(List<Swimmer> swimmers) {
    this.swimmers = swimmers;
    this.index = 0;
  }

  public boolean isQualified(Swimmer s) {
    if (s.getButterfly50mTimes().size() >= 5) {
      for (double time : s.getFreestyle50mTimes()) {
        if (time <= 26.17) return true;
      }
    }
    return false;
  }

  public boolean hasNext() {
    while (index < swimmers.size()) {
      if (isQualified(swimmers.get(index))) return true;
      index++;
    }
    return false;
  }

  public Swimmer next() {
    Swimmer current = swimmers.get(index);
    index++;
    return current;
  }
}
