package org.example;

import org.example.filesystem.FileSystemReader;

public class Main {
    public static void main(String[] args) {
        FileSystemReader.printDirectoriesToConsole("D://");
        FileSystemReader.outputDirectoriesToFile("D://", "./new.txt");

        FileSystemReader.printInnerFilesToConsole("D://");
        FileSystemReader.outputInnerFilesToFile("D://", "./new.txt");
    }
}