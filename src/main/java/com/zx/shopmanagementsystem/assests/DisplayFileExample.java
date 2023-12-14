package com.zx.shopmanagementsystem.assests;

import java.io.File;

public class DisplayFileExample {

    public void printFileNames(File directory) {
        if (directory.exists() && directory.isDirectory()) {
            printFileNames(directory.listFiles(), 0);
        } else {
            System.out.println("Invalid directory path.");
        }
    }

    private void printFileNames(File[] files, int index) {
        if (index == files.length) {
            return;
        }

        if (files[index].isFile()) {
            System.out.println(files[index].getName());
        }

        printFileNames(files, index + 1);
    }

    public static void main(String[] args) {
        // Providing the full path for the directory
        String path = "E:";
        // creating a file object
        File directory = new File(path);

        // creating an object of the class DisplayFileExample
        DisplayFileExample obj = new DisplayFileExample();

        obj.printFileNames(directory);
    }
}
