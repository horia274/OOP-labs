package com.poo.labvisitor.task2;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

/**
 * Counter for java files of a given directory using java.nio API
 */
public class JavaFilesVisitor extends SimpleFileVisitor<Path> {

    private ArrayList<Path> javaFiles = new ArrayList<>();

    public final ArrayList<Path> getJavaFiles() {
        return javaFiles;
    }

    // TODO - override the visitFile(Path file, BasicFileAttributes attr) method of the SimpleFileVisitor
    // add to javaFiles all the Java related files: the ones with .java and .class extensions

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes attr) {
        String typeFile = null;
        if (path.toString().endsWith(".class")) {
            typeFile = "class";
        }
        if (path.toString().endsWith(".java")) {
            typeFile = "java";
        }
        if (typeFile != null) {
            javaFiles.add(path);
            String name = path.toString().substring(path.toString().lastIndexOf("/") + 1);
            System.out.println("Name: " + name);
            System.out.println("Type: " + typeFile);
            System.out.println("Size: " + attr.size());
            System.out.println("Creation time: " + attr.creationTime() + "\n");
        }
        return FileVisitResult.CONTINUE;
    }

    public static void main(String[] args) throws IOException {

        Path startingDir = Paths.get(".");
        JavaFilesVisitor filesVisitor = new JavaFilesVisitor();

        // TODO
        // use Files.walkFileTree
        // obtain the list of files and print some info about them (e.g. size and path)
        Files.walkFileTree(startingDir, filesVisitor);
    }
}
