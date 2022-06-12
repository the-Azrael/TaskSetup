import java.io.*;

public class Main {
    private static final String GAMES_DIR = "D://Java//Games";
    private static StringBuilder log = new StringBuilder();
    private static File gamesFile = new File(GAMES_DIR);
    private static File tempFile = new File(GAMES_DIR + "//temp");
    private static File tempTempTxtFile = new File(tempFile.getAbsolutePath() + "//temp.txt");
    private static File srcFile = new File(GAMES_DIR + "//src");
    private static File mainFile = new File(srcFile.getAbsolutePath() + "//main");
    private static File testFile = new File(srcFile.getAbsolutePath() + "//test");
    private static File mainJavaFile = new File(mainFile.getAbsolutePath() + "//Main.java");
    private static File utilsJavaFile = new File(mainFile.getAbsolutePath() + "//Utils.java");
    private static File resFile = new File(GAMES_DIR + "//res");
    private static File drawablesFile = new File(resFile + "//drawables");
    private static File vectorsFile = new File(resFile + "//vectors");
    private static File iconsFile = new File(resFile + "//icons");
    private static File saveGamesFile = new File(GAMES_DIR + "//savegames");

    private static void addFileMessage(File file) {
        if (!file.exists()) {
            log.append("Путь \'" + file.getAbsolutePath() + "\' не создан\n");
        } else {
            if (file.isFile()) {
                log.append("Файл \'" + file.getAbsolutePath() + "\' создан\n");
            } else if (file.isDirectory()) {
                log.append("Папка \'" + file.getAbsolutePath() + "\' создана\n");
            }
        }
    }

    private static void createFileForWrite(File file, boolean isFile) {
        boolean isCreated = false;
        if (!file.exists()) {
            try {
                isCreated = isFile ? file.createNewFile() : file.mkdir();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        addFileMessage(file);
        file.setWritable(true);
    }

    private static void writeStringBuilder(File file, StringBuilder sb) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(sb.toString());
            fileWriter.close();
            System.out.println(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(sb.toString());
        }
    }

    public static void main(String[] args) throws IOException {
        if (gamesFile.exists() && gamesFile.isDirectory()) {
            log.append("Корневая папка \'" + gamesFile.getAbsolutePath() + "\' на месте\n");
        } else {
            System.out.println("Корневая папка \'" + gamesFile.getAbsolutePath() + "\' не создана!\n");
        }
        createFileForWrite(srcFile, false);
        createFileForWrite(resFile, false);
        createFileForWrite(saveGamesFile, false);
        createFileForWrite(tempFile, false);
        createFileForWrite(mainFile, false);
        createFileForWrite(testFile, false);
        createFileForWrite(mainJavaFile, true);
        createFileForWrite(utilsJavaFile, true);
        createFileForWrite(drawablesFile, false);
        createFileForWrite(vectorsFile, false);
        createFileForWrite(iconsFile, false);
        createFileForWrite(tempTempTxtFile, true);

        writeStringBuilder(tempTempTxtFile, log);
    }
}
