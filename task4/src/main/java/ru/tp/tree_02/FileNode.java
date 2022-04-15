package ru.tp.tree_02;

import java.util.ArrayList;
import java.util.List;

public class FileNode {
    public String name;
    public boolean isDir;
    public List<FileNode> children;

    public FileNode() {
        children = new ArrayList<>();
    }
}
