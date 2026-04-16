package Problem1;

import java.util.*;
import java.util.stream.Collectors;

public class TrendingTopics {
    public Map<String, Long> countTopics(List<String> topics) {
        Map<String, Long> result = topics.stream()
                .collect(Collectors.groupingBy(
                        s -> s,
                        Collectors.counting()
                ));
        return result;
    }

    public static void main(String[] args) {
        String data = "Seattle, wildfires, DEFCON26, NEU, NEU, Seattle, Seattle, NEU, DEFCON26, wildfires";
        List<String> topics = new ArrayList<>(Arrays.asList(data.split(", ")));

        TrendingTopics tt = new TrendingTopics();
        Map<String, Long> result = tt.countTopics(topics);
        for (Map.Entry<String, Long> entry : result.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}