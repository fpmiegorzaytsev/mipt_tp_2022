package ru.tp.tree_02;


import org.junit.Test;

import java.io.FileNotFoundException;

import java.nio.file.NotDirectoryException;

public class TreeTest {

    @Test(expected = FileNotFoundException.class)
    public void testForFileNotFoundException() throws NotDirectoryException, FileNotFoundException {
        Tree.getTree("Not a file path", false);
    }

    @Test(expected = NotDirectoryException.class)
    public void testForNotDirectoryException() throws NotDirectoryException, FileNotFoundException {
        Tree.getTree("./src/test/java/ru/tp/tree_02/TreeTest.java", false);
    }

    @Test
    public void testForGetTreeMethod() throws NotDirectoryException, FileNotFoundException {
        Tree.getTree("./src/test/java/ru/tp/tree_02/", true);
        Tree.getTree("./src/test/java/ru/tp/tree_02/", false);
        Tree.getTree("./src/test/java/", true);
    }

    @Test
    public void testForFilterEmptyNodes(){
        FileNode node1 = new FileNode();
        FileNode node2 = new FileNode();
        node1.isDir = false;
        node2.isDir = true;
        Tree.filterEmptyNodes(node1, "./src/test/java/ru/tp/tree_02/");
        Tree.filterEmptyNodes(node2, "./src/test/java/ru/tp/tree_02/");
    }







}
