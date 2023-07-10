package task1;

import java.io.File;

public class PhoneCheckerTest {
    public static void main(String[] args) {
        File file = new File("file-task1.txt");
        new PhoneChecker().printValidPhones(file);
        System.out.println("\nAll done!");
    }
}
