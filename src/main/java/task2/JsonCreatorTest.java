package task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonCreatorTest {
    public static void main(String[] args) {
        File inputFile = new File("file-task2.txt");
        List<User> users = new ArrayList<>();
        new UsersListCreator().parseFileToList(users, inputFile);
//        System.out.println(users);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(users.toArray());
//        System.out.println(json);

        File outputFile = new File("user.json");
        try (FileWriter writer = new FileWriter(outputFile))
        {
            writer.write(json);
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
