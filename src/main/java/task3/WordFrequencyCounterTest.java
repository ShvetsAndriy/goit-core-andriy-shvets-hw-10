package task3;

import java.io.File;
import java.util.*;

public class WordFrequencyCounterTest {
    public static void main(String[] args) {
        File inputFile = new File("words-task3.txt");
        Map<String, Integer> unsortedWords = new HashMap<>();
        new WordFrequencyCounter().parseFileToMap(unsortedWords, inputFile);

//        System.out.println(unsortedWords);

        SortedMap<String, Integer> sortedWords = new TreeMap<>(new Comparator<>() {
            private final TreeMap<String, Integer> map = new TreeMap<>(unsortedWords);
            @Override
            public int compare(String k1, String k2) {
                int v1 = map.get(k1);
                int v2 = map.get(k2);
//                if (Objects.equals(v1, v2)){
//                    return 0;
//                }
                return v1 < v2 ? 1 : -1;
            }
        });
        sortedWords.putAll(unsortedWords);

        System.out.println(sortedWords);

    }
}
