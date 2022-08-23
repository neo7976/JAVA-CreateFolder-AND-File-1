import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static final String WAY = "E:/IT/Java/0. Обучение Java/1. Нетология/Java-разработчик с нуля" + "/";
    public static final String PATHNAME = "5. Шаблоны проектирования" + "/";

    public static final String PARHNAME_STANDART1 = "/" + "Homework";
    public static final String PARHNAME_STANDART2 = "/" + "Video";
    public static final String PARHNAME_STANDART3 = "/" + "Тест";

    public static void main(String[] args) {
        File games = new File(WAY + PATHNAME);
        folderCreation(games);

        String folder1 = "1. " + "Порождающие шаблоны (Builder, Singleton, Factory Method, Abstract Factory, Prototype)";
        String folder2 = "2. " + "Структурные шаблоны (Proxy, Decorator, Adapter)";
        String folder3 = "3. " + "Поведенческие шаблоны (Command, Iterator, Observer, Chain of Responsibility)";
        String folder4 = "4. " + "Magics, DRY, SOLID";
//        String folder5 = "5. " + "null5";
//        String folder6 = "6. " + "null6";
//        String folder7 = "7. " + "null7";
//        String folder8 = "8. " + "null8";
//        String folder9 = "9. " + "null9";
//        String folder10 = "10. " + "null10";

        //1
        createFolder(WAY + PATHNAME, folder1
                , folder2
                , folder3
                , folder4
//                , folder5
//                , folder6
//                , folder7
//                , folder8
//                , folder9
//                , folder10
        );

        //2
        createFolderOrFile(WAY + PATHNAME + folder1, PARHNAME_STANDART1, PARHNAME_STANDART2, PARHNAME_STANDART3);
        createFolderOrFile(WAY + PATHNAME + folder2, PARHNAME_STANDART1, PARHNAME_STANDART2, PARHNAME_STANDART3);
        createFolderOrFile(WAY + PATHNAME + folder3, PARHNAME_STANDART1, PARHNAME_STANDART2, PARHNAME_STANDART3);
        createFolderOrFile(WAY + PATHNAME + folder4, PARHNAME_STANDART1, PARHNAME_STANDART2, PARHNAME_STANDART3);
//        createFolderOrFile(WAY + PATHNAME + folder5, PARHNAME_STANDART1, PARHNAME_STANDART2, PARHNAME_STANDART3);
//        createFolderOrFile(WAY + PATHNAME + folder6, PARHNAME_STANDART1, PARHNAME_STANDART2, PARHNAME_STANDART3);
//        createFolderOrFile(WAY + PATHNAME + folder7, PARHNAME_STANDART1, PARHNAME_STANDART2, PARHNAME_STANDART3);
//        createFolderOrFile(WAY + PATHNAME + folder8, PARHNAME_STANDART1, PARHNAME_STANDART2, PARHNAME_STANDART3);
//        createFolderOrFile(WAY + PATHNAME + folder9, PARHNAME_STANDART1, PARHNAME_STANDART2, PARHNAME_STANDART3);
//        createFolderOrFile(WAY + PATHNAME + folder10, PARHNAME_STANDART1, PARHNAME_STANDART2, PARHNAME_STANDART3);

//        //3
//        createFolderOrFile(WAY + PATHNAME+ "/src/main", "Main.java", "Utils.java");

        createFolderOrFile(WAY + PATHNAME, "temp.txt");

        try (FileWriter writer = new FileWriter(WAY + PATHNAME + "/temp.txt", false)) {
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

    public static void createFolder(String file, String... folder) {
        for (String s : folder) {
            File file1 = new File(file, s);
            folderCreation(file1);
        }
    }
}
