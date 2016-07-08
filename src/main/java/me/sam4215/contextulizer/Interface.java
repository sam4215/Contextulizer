package me.sam4215.contextulizer;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

/**
 * THIS CODE MAY BE LICENSED AND/OR COPYRIGHTED BY EMULSION TECHNOLOGIES.
 *
 * @author Sam ("sam4215")
 *         <p/>
 *         CREATED FOR PROJECT: Contextulizer IN me.sam4215.contextulizer
 *         <p/>
 *         FILE CREATED ON 7/12/2015 at 2:17 PM
 */
public class Interface {
    public static void init() {
        System.out.println("Entered category editor interface");
        try {
            InputStream input = new FileInputStream("src/main/yaml/fileListing.yml");
            Yaml yaml = new Yaml();
            List<String> categories = (List<String>) yaml.load(input);
            System.out.println("CATEGORIES ---- \n" + categories);
        } catch(FileNotFoundException e) {
            System.out.println("Contextulizer can't find src/main/yaml/categories.yml - is it missing or inaccessable?");
            System.out.println("Submit the crash log below\n\n");
            e.printStackTrace();
        }
    }
}
