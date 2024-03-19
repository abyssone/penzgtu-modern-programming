package org.example.output;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.example.output.Utils.outputDirectoryFormat;
import static org.example.output.Utils.outputFileFormat;

public class DirectoriesFileOutput {

    public void outputDirectories(List<File> directories, String file) {
        try (FileWriter writer = new FileWriter(file, false)) {
            System.out.println("Start output to " + file);

            for (File directory : directories) {
                String string = outputDirectoryFormat(directory.getName(), 0, false);
                writer.write(string);
                writer.write("\n");

                File[] innerDirectories = directory.listFiles(File::isDirectory);
                if (innerDirectories != null && innerDirectories.length > 0) {
                    outputInnerDirectories(Arrays.stream(innerDirectories).toList(), 0, writer);
                }
            }

            System.out.println("End output to " + file);
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }

    public void outputInnerFiles(List<File> files, String file) {
        try (FileWriter writer = new FileWriter(file, false)) {
            System.out.println("Start output to " + file);

            for (File innerFile : files) {
                writer.write(outputFileFormat(innerFile));
                writer.write("\n");
            }

            System.out.println("End output to " + file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void outputInnerDirectories(List<File> directories, int order, FileWriter writer) throws IOException {
        for (int i = 0; i < directories.size(); i++) {
            File directory = directories.get(i);

            String string = outputDirectoryFormat(directory.getName(), order, i + 1 == directories.size());
            writer.write(string);
            writer.write("\n");

            File[] innerDirectories = directory.listFiles(File::isDirectory);
            if (innerDirectories != null && innerDirectories.length > 0) {
                outputInnerDirectories(Arrays.stream(innerDirectories).toList(), order + 1 , writer);
            }
        }
    }
}
