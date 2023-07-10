package task2;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class UsersListCreator {
    public void parseFileToList (List User, File file) {
        try (Scanner scanner = new Scanner(new FileReader(file))) {
            int lineNumber = 0;
            while (scanner.hasNextLine()) {
                String dataLine = scanner.nextLine();
                if (lineNumber == 0) {
                    lineNumber++;
                    continue;
                }
                String[] userData;
                if (!dataLine.isEmpty()) {
                    userData = dataLine.split(" ");
                } else {
                    continue;
                }
                User.add(new User(userData[0], Integer.parseInt(userData[1])));
                lineNumber++;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
