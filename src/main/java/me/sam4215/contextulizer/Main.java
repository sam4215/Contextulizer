package me.sam4215.contextulizer;

import me.sam4215.contextulizer.annotation.Experimental;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.List;
import java.util.Scanner;

/**
 * THIS CODE MAY BE LICENSED AND/OR COPYRIGHTED BY EMULSION TECHNOLOGIES.
 *
 * @author Sam ("sam4215")
 *         <p/>
 *         CREATED FOR PROJECT: Contextulizer IN me.sam4215.contextulizer
 *         <p/>
 *         FILE CREATED ON 6/24/2015 at 11:31 AM
 *
 * Oh yeah, note to self. When I say FTE, I mean File Type Extension.
 */
public class Main {
    public static void main(String[] args) {
        try {
            InputStream input = new FileInputStream("src/main/yaml/fileListing.yml");
            Yaml yaml = new Yaml();
            yaml.load(input);
        } catch (FileNotFoundException e) {
            System.out.println("Error: File fileListing.yml in src/main/yaml is missing. ");
        }
        if(args[0].contains(".")) {
            /**
             * This list is the representation of the split file
             *
             * You shouldn't use this as Strings are available to do the same thing.
             *
             * @return splitFileName[0] gets fileName, splitFileName[1] gets fileTypeExt
             */
            String[] splitFileName = args[0].split(".");
            /**
             * Gets the file's File Type Extension
             *
             * @return FTE
             */
            String fileTypeExt = splitFileName[1];
            /**
             * Gets the file's name (excluding File Type Extension)
             *
             * @return The file's short name
             */
            String fileName = splitFileName[0];
            /**
             * Gets the absolute name of a file, including its File Type Extension.
             *
             * @return The absolute name of a file
             **/
            String fullFileName = args[0];
            /**
             * Gets the file's type by using its FTE.
             *
             * *May not* work in uncommon file types (etc proprietary file types, .1 or .2 files, etc)
             *
             * @return The file's type
             *
             * <b>Experimental, therefore deprecated until further notice</b>
             *
             * <i>Dev note: wil be grabbed from YAML in src/main/yaml/fileListing.yml</i>
             */
            @Deprecated
            @Experimental
            String fileType;
            try {
                InputStream input = new FileInputStream("src/main/yaml/knownFileTypes.yml");
                Yaml yaml = new Yaml();
                /*
                 *  Based on file type ext, potential security flaw
                 *
                 *  TODO get metadata or similar
                 *
                 *  Also use fileTypeList.yml
                 */
                List<String> knownFileTypes = (List<String>) yaml.load(input);
                if(!knownFileTypes.contains(fileTypeExt)) {
                    System.out.println("Warning >> The file you are trying to input is NOT a known file type and may be dangerous. If you do not trust this file, exit the program and delete it immediately!");
                    System.out.println("Inputting file in 10 seconds. If you do not trust this file, click the X now!");
                    Thread.sleep(1000);
                }
                System.out.println("Inputting file " + fileName);
                Writer writer = new FileWriter("src/main/yaml/fileListing.yml", true);
                yaml.dump(fileName, writer);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } catch (IOException exe) {
                exe.printStackTrace();
            }

        }
    }
}
