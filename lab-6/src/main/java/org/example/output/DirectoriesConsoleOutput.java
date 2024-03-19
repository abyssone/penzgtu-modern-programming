package org.example.output;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.example.output.Utils.outputDirectoryFormat;
import static org.example.output.Utils.outputFileFormat;

public class DirectoriesConsoleOutput {

    public void printDirectories(List<File> directories) {
        for (File directory : directories) {
            String string = outputDirectoryFormat(directory.getName(), 0, false);
            System.out.println(string);

            File[] innerDirectories = directory.listFiles(File::isDirectory);
            if (innerDirectories != null && innerDirectories.length > 0) {
                printInnerDirectories(Arrays.stream(innerDirectories).toList(), 0);
            }
        }
    }

    public void printInnerFiles(List<File> files) {
        for (File innerFile : files) {
            System.out.println(outputFileFormat(innerFile));
        }
    }

    private void printInnerDirectories(List<File> directories, int order) {
        for (int i = 0; i < directories.size(); i++) {
            File directory = directories.get(i);

            String string = outputDirectoryFormat(directory.getName(), order, i + 1 == directories.size());
            System.out.println(string);

            File[] innerDirectories = directory.listFiles(File::isDirectory);
            if (innerDirectories != null && innerDirectories.length > 0) {
                printInnerDirectories(Arrays.stream(innerDirectories).toList(), order + 1);
            }
        }
    }
}
