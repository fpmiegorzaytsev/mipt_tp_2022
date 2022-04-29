package ru.tp.tree_02;


import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.NotDirectoryException;
import java.nio.file.Paths;
import java.util.Objects;

public class Tree {
    public static FileNode getTree(String path, boolean dirsOnly) throws FileNotFoundException, NotDirectoryException {
        FileNode answer = new FileNode();
        File pathFile = new File(path);
        if (!pathFile.exists()) {
            throw new FileNotFoundException("File not found");
        }

        if (!pathFile.isDirectory()) {
            throw new NotDirectoryException("Not directory");
        }

        answer.name = pathFile.getName();
        answer.isDir = true;

        for (File child: Objects.requireNonNull(pathFile.listFiles())) {
            if (child.isDirectory()) {
                answer.children.add(getTree(child.toString(), dirsOnly));
            } else {
                if (dirsOnly) {
                    continue;
                }
                FileNode insideNode = new FileNode();
                insideNode.name = child.getName();
                insideNode.isDir = false;
                answer.children.add(insideNode);
            }
        }
        return answer;
    }

    public static void filterEmptyNodes(FileNode node, String currentPath) {
        if (!node.isDir) {
            return;
        }

        if (node.children.isEmpty()) {
            new File(currentPath).delete();
        }

        for (FileNode child:  node.children) {
            filterEmptyNodes(child, Paths.get(currentPath, child.name).toString());
        }
    }
}
