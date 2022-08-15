import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static final String WAY = "E:/IT/Java/0. Обучение Java/1. Нетология/Java-разработчик с нуля" + "/";
    public static final String PATHNAME = "5465555465465" + "/";

    public static final String PARHNAME_STANDART1 = "/" + "Homework";
    public static final String PARHNAME_STANDART2 = "/" + "Video";
    public static final String PARHNAME_STANDART3 = "/" +"Тест";

    public static void main(String[] args) {
        File games = new File(WAY + PATHNAME);
        folderCreation(games);

        String folder1 = "null1";
        String folder2 = "null2";
        String folder3 = "null3";
        String folder4 = "null4";
        String folder5 = "null5";
        String folder6 = "null6";
        String folder7 = "null7";
        String folder8 = "null8";
        String folder9 = "null9";
        String folder10 = "null10";

        //1
        createFolderOrFile(WAY + PATHNAME, folder1
                , folder2
                , folder3
                , folder4
                , folder5
                , folder6
                , folder7
                , folder8
                , folder9
                , folder10
        );

        //2
        createFolderOrFile(WAY + PATHNAME + folder1, PARHNAME_STANDART1, PARHNAME_STANDART2, PARHNAME_STANDART3);
        createFolderOrFile(WAY + PATHNAME + folder2, PARHNAME_STANDART1, PARHNAME_STANDART2, PARHNAME_STANDART3);
        createFolderOrFile(WAY + PATHNAME + folder3, PARHNAME_STANDART1, PARHNAME_STANDART2, PARHNAME_STANDART3);
        createFolderOrFile(WAY + PATHNAME + folder4, PARHNAME_STANDART1, PARHNAME_STANDART2, PARHNAME_STANDART3);
        createFolderOrFile(WAY + PATHNAME + folder5, PARHNAME_STANDART1, PARHNAME_STANDART2, PARHNAME_STANDART3);
        createFolderOrFile(WAY + PATHNAME + folder6, PARHNAME_STANDART1, PARHNAME_STANDART2, PARHNAME_STANDART3);
        createFolderOrFile(WAY + PATHNAME + folder7, PARHNAME_STANDART1, PARHNAME_STANDART2, PARHNAME_STANDART3);
        createFolderOrFile(WAY + PATHNAME + folder8, PARHNAME_STANDART1, PARHNAME_STANDART2, PARHNAME_STANDART3);
        createFolderOrFile(WAY + PATHNAME + folder9, PARHNAME_STANDART1, PARHNAME_STANDART2, PARHNAME_STANDART3);
        createFolderOrFile(WAY + PATHNAME + folder10, PARHNAME_STANDART1, PARHNAME_STANDART2, PARHNAME_STANDART3);

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
}
