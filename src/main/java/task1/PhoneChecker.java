package task1;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PhoneChecker {
    public void printValidPhones (File file) {
        try (Scanner scanner = new Scanner(new FileReader(file))) {
            while (scanner.hasNextLine()) {
                String phoneNumber = scanner.nextLine();
                if (rightNumber(phoneNumber)) {
                    System.out.println(phoneNumber);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean rightNumber (String phoneNumber) {
        String regex = "(\\(\\d{3}\\)\\s|\\d{3}-)\\d{3}-\\d{4}";
//        String regex = "(\\d|\\()\\d\\d(-|\\d)(\\d|\\))(\\d|\\s)\\d(-|\\d)\\d(\\d|-)(\\d{2}|\\d{4})";
        return phoneNumber.matches(regex);
    }
}
