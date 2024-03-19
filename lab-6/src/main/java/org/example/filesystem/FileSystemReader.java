package org.example.filesystem;

import org.example.output.DirectoriesConsoleOutput;
import org.example.output.DirectoriesFileOutput;
import org.example.output.Utils;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileSystemReader {

    private static final DirectoriesConsoleOutput consoleOutput = new DirectoriesConsoleOutput();
    private static final DirectoriesFileOutput fileOutput = new DirectoriesFileOutput();

    public static void printDirectoriesToConsole(String path) {
        File file = new File(path);

        if (!file.isDirectory()) {
            System.out.println("Путь не является путем к папке");
        }

        List<File> directories = Arrays.stream(file.listFiles(File::isDirectory)).toList();
        consoleOutput.printDirectories(directories);
    }

    public static void outputDirectoriesToFile(String path, String filePath) {
        File file = new File(path);

        if (!file.isDirectory()) {
            System.out.println("Путь не является путем к папке");
        }

        List<File> directories = Arrays.stream(file.listFiles(File::isDirectory)).toList();
        fileOutput.outputDirectories(directories, filePath);
    }

    public static void printInnerFilesToConsole(String path) {
        File file = new File(path);

        if (file.isDirectory()) {
            List<File> files = Arrays.stream(file.listFiles())
                    .sorted(Utils.directoriesIsFirst)
                    .collect(Collectors.toList());

            consoleOutput.printInnerFiles(files);
        } else {
            System.out.println("is not directory");
        }
    }

    public static void outputInnerFilesToFile(String path, String filePath) {
        File file = new File(path);

        if (file.isDirectory()) {
            List<File> files = Arrays.stream(file.listFiles())
                    .sorted(Utils.directoriesIsFirst)
                    .collect(Collectors.toList());

            fileOutput.outputInnerFiles(files, filePath);
        } else {
            System.out.println("is not directory");
        }
    }
}
