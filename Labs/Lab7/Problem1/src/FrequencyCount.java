import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyCount {
  public static void main(String[] args) {
    List<Integer> list = List.of(1, 1, 1, 2, 2, 3, 3, 4, 4, 4);
    FrequencyCount counter = new FrequencyCount();
    Map<Integer, Double> result = counter.frequencyCount(list);
    System.out.println(result);
  }

  public Map<Integer, Double> frequencyCount(List<Integer> list) {
    Map<Integer, Double> dataCollection = new HashMap<>();

    for (int num : list) {
      if (dataCollection.containsKey(num)) dataCollection.put(num, dataCollection.get(num) + 1.0);
      else dataCollection.put(num, 1.0);
    }

    dataCollection.replaceAll((k, v) -> dataCollection.get(k) / list.size());
    return dataCollection;
  }
}
