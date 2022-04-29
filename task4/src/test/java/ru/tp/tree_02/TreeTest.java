package ru.tp.tree_02;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TreeTest {

    private Path highDirectoryPath;
    private Path middleDirectoryPath;
    private Path lowDirectoryPath;
    private Path filePath;


    @Before
    public void setUp() throws IOException {
        Path path = Paths.get("").toAbsolutePath();
        highDirectoryPath = Files.createTempDirectory(path,"highDir");
        middleDirectoryPath = Files.createTempDirectory(highDirectoryPath, "middleDir");
        lowDirectoryPath = Files.createTempDirectory(middleDirectoryPath, "lowDir");
        filePath = File.createTempFile("file", ".java", lowDirectoryPath.toFile()).toPath();
    }

    @After
    public void tearDown() throws IOException {
        Files.delete(filePath);
        Files.delete(lowDirectoryPath);
        Files.delete(middleDirectoryPath);
        Files.delete(highDirectoryPath);
    }

    @Test(expected = FileNotFoundException.class)
    public void testForFileNotFoundException() throws NotDirectoryException, FileNotFoundException {
        Tree.getTree("Not a file path", false);
    }

    @Test(expected = NotDirectoryException.class)
    public void testForNotDirectoryException() throws NotDirectoryException, FileNotFoundException {
        Tree.getTree(filePath.toString(), false);
    }

    @Test
    public void testForGetTreeMethod1() throws NotDirectoryException, FileNotFoundException {
        Tree.getTree(middleDirectoryPath.toString(), true);

    }

    @Test
    public void testForGetTreeMethod2() throws NotDirectoryException, FileNotFoundException {
        Tree.getTree(middleDirectoryPath.toString(), false);
    }

    @Test
    public void testForGetTreeMethod3() throws NotDirectoryException, FileNotFoundException{
        Tree.getTree(highDirectoryPath.toString(), true);
    }

    @Test
    public void testForFilterEmptyNodes1(){
        FileNode node = new FileNode();
        node.isDir = false;
        Tree.filterEmptyNodes(node, middleDirectoryPath.toString());
    }

    @Test
    public void testForFilterEmptyNodes2(){
        FileNode node = new FileNode();
        node.isDir = true;
        Tree.filterEmptyNodes(node, middleDirectoryPath.toString());
    }

}
