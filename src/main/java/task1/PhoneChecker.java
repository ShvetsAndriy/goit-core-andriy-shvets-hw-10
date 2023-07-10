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
                    System.out.println(phoneNumber + " ");
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean rightNumber (String phoneNumber) {
        int lengthNumber = phoneNumber.length();
        if (lengthNumber < 12 || lengthNumber > 14) {
            return false;
        }
        String digits = "0123456789";
        char symbol;
        boolean isDigit;
        for (int i=0; i < lengthNumber; i++) {
            symbol = phoneNumber.charAt(i);
            isDigit = digits.contains(String.valueOf(symbol));

            if (i == 0 && !(isDigit || symbol == '(')) {
                return false;
            }
            if ((i == 1 || i == 2) && !isDigit) {
                return false;
            }
            if (i == 3 && !(isDigit || symbol == '-')) {
                return false;
            }
            if (i == 4 && !(isDigit || symbol == ')')) {
                return false;
            }
            if (i == 5 && !(isDigit || symbol == ' ')) {
                return false;
            }
            if (i == 6 && !isDigit) {
                return false;
            }
            if (i == 7 && !(isDigit || symbol == '-')) {
                return false;
            }
            if (i == 8 && !isDigit) {
                return false;
            }
            if (i == 9 && !(isDigit || symbol == '-')) {
                return false;
            }
            if ((i == 10 || i == 11) && !isDigit) {
                return false;
            }
            if (lengthNumber > 12 && (i == 12 || i == 13) && !isDigit) {
                return false;
            }
        }
        return true;
    }
}
