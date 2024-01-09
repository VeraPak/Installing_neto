import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        String[] dirs = {"src", "res", "savegames", "temp",
                "src/main", "src/test",
                "res/drawables", "res/vectors", "res/icons"};
        ArrayList<String> listOfDirs = new ArrayList<>(List.of(dirs));
        for (String f : listOfDirs) {
            createDirectory("/Users/vera/Games/"+f);
        }

        createFile("/Users/vera/Games/src/main", "Main.java");
        createFile("/Users/vera/Games/src/main", "Utils.java");
        createFile("/Users/vera/Games/temp", "temp.txt");

        try (FileWriter fw = new FileWriter("/Users/vera/Games/temp/temp.txt")) {
            fw.append(sb);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void createDirectory(String path){
        File file = new File(path);
        sb.append(file.mkdir() ? "Директория " + file.getName() + " успешно создана\n" : "Директория " + file.getName() + " не создана\n");
    }

    private static void createFile(String path, String name) {
        File file = new File(path, name);
        try {
            sb.append(file.createNewFile() ? "Файл " + file.getName() + " успешно создан\n" : "Файл " + file.getName() + " не создан\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
