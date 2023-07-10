package task3;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class WordFrequencyCounter {
    public void parseFileToMap(Map map, File file) {
        String word = "";

        try (FileReader reader = new FileReader(file)) {
            char[] buffer = new char[(int) file.length()];
            reader.read(buffer);
            for (char c : buffer) {
                if (c >= 'a' & c <= 'z') {
                    word += c;
                } else if (!word.equals("")) {
                    if (!map.containsKey(word)) {
                        map.put(word, 1);
                    } else {
                        map.put(word, (int) map.get(word) + 1);
                    }
                    word = "";
                }
            }
            if (!word.equals("")) {
                if (!map.containsKey(word)) {
                    map.put(word, 1);
                } else {
                    map.put(word, (int) map.get(word) + 1);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
