package org.example.output;

import java.io.File;
import java.util.Comparator;

public class Utils {

    public static final Comparator<File> directoriesIsFirst = (o1, o2) -> {
        if (o2.isDirectory() && !o1.isDirectory()) return 1;
        if (!o2.isDirectory() && o1.isDirectory()) return -1;
        return 0;
    };

    public static String outputDirectoryFormat(String directoryName, int order, boolean isLast) {
        StringBuilder builder = new StringBuilder(directoryName);

        if (isLast) {
            builder.insert(0, "╵— ");
        } else {
            builder.insert(0, "|— ");
        }

        for (int i = 0; i < order; i++) {
            builder.insert(0, "\t");
        }

        return builder.toString();
    }

    public static String outputFileFormat(File file) {
        if (file.isDirectory()) {
            return String.format("- %s", file.getName());
        } else {
            return file.getName();
        }
    }
}
