import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static final String WAY = "E:/IT/Java/0. Обучение Java/1. Нетология/Java-разработчик с нуля";
    public static final String PATHNAME = "5465465465/";

    public static final String PARHNAME_STANDART1 = "Homework";
    public static final String PARHNAME_STANDART2 = "Video";
    public static final String PARHNAME_STANDART3 = "Тест";

    public static void main(String[] args) {
        File games = new File(WAY + PATHNAME);
        folderCreation(games);

        //1
        createFolderOrFile(PATHNAME, "src", "res", "savegames", "temp");

        //2
        createFolderOrFile(PATHNAME + "/src", "main", "test");

        //3
        createFolderOrFile(PATHNAME + "/src/main", "Main.java", "Utils.java");

        //4
        createFolderOrFile(PATHNAME + "/res", "drawables", "vector", "icons");

        //5
        createFolderOrFile(PATHNAME + "/temp", "temp.txt");

        try (FileWriter writer = new FileWriter(PATHNAME + "/temp/temp.txt", false)) {
            writer.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void fileCreation(File mainJava) {
        try {
            if (mainJava.createNewFile())
                sb.append(mainJava).append(" - Файл успешно создан\n");
            else if (mainJava.isFile())
                sb.append(mainJava).append("- Файл уже существует\n");
            else
                sb.append(mainJava).append(" - Файл не был создан\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void folderCreation(File games) {
        if (games.mkdir())
            sb.append(games).append(" - Папка успешно создана\n");
        else if (games.isDirectory())
            sb.append(games).append(" - Папка уже существует\n");
        else
            sb.append(games).append(" - Папка не была создана\n");
    }

    public static void createFolderOrFile(String file, String... folderOrFile) {
        for (String s : folderOrFile) {
            File file1 = new File(file, s);
            if (s.contains("."))
                fileCreation(file1);
            else
                folderCreation(file1);
        }
    }
}
