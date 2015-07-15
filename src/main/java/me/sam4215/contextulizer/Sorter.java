package me.sam4215.contextulizer;

import me.sam4215.contextulizer.Main;

import java.io.File;
import java.io.OutputStream;

/**
 * THIS CODE MAY BE LICENSED AND/OR COPYRIGHTED BY EMULSION TECHNOLOGIES.
 *
 * @author Sam ("sam4215")
 *         <p/>
 *         CREATED FOR PROJECT: Contextulizer IN me.sam4215.contextulizer
 *         <p/>
 *         FILE CREATED ON 7/11/2015 at 10:08 PM
 */
public class Sorter {
    Main main = new Main();

    /**
     * This method sorts <code>file</code> into <code>pathToDestination</code>.
     *
     * If successful, it displays <code>msgIfSuccess</code>, otherwise, it displays <code>msgIfFailure</code>
     *
     * @author Sam ("sam4215")
     * @since DEV
     * @param file
     * @param pathToDestination
     * @param msgIfSuccess
     * @param msgIfFailure
     */
    public void sort(File file, File pathToDestination, String msgIfSuccess, String msgIfFailure) {
        /**
         * Safety Checks to make sure the file doesn't get corrupted or the like
         *
         * @since 1.0.0
         */
        if(!pathToDestination.isDirectory()) {
            System.out.println("Target directory doesn't exist or is invalid. Terminating to prevent file loss!");
            System.out.println(msgIfFailure);
            System.exit(2);
        }
        if(!file.exists()) {
            System.out.println("That file's either not there, Contextulizer can't access it, or it's not a file.");
            System.out.println(msgIfFailure);
            System.exit(3);
        }
        file.getAbsoluteFile().renameTo(pathToDestination);
        System.out.println("Successfully sorted file into " + pathToDestination);
        System.out.println(msgIfSuccess);
        System.exit(0);
    }
}
