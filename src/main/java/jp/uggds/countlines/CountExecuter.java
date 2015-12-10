package jp.uggds.countlines;

import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;

/**
 * @auther uga
 */
public class CountExecuter {
    private File directory;

    private String[] extensions;

    public CountExecuter(File directory, String[] extensions) {
        this.directory = directory;
        this.extensions = extensions;
    }
    @SuppressWarnings("unchecked")
    public void count() throws IOException {

        Collection<File> files = FileUtils.listFiles(directory, extensions, true);
        int count = 0;
        if (files != null) {
            for (File f : files) {
                count += countLines(f);
            }
        }

        System.out.println("Total Linenumber is " + count + " .");
        System.out.println("directory " + directory.getPath());
    }

    private int countLines(File file) throws IOException {
        int linenum = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line = null;
            while ((line = br.readLine()) != null) {
                linenum++;
            }
        }
        return linenum;
    }

}
