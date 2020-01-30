package src.com.javarush.task.task20.task2028;

import java.io.Serializable;

public class Entry<T> implements Serializable {

    String nodeName;
    static int line;
    boolean hasLeftChild, hasRigthChild;
    Entry<T> leftChild, rigthChild;

    public Entry() {
        this.nodeName = "";
        int line = 0;
        hasLeftChild = false;
        hasRigthChild = false;
        leftChild = null;
        rigthChild = null;
    }

    public Entry(String name) {
        this.nodeName = name;
        int line = 0;
        hasLeftChild = false;
        hasRigthChild = false;
        leftChild = null;
        rigthChild = null;
    }

    public boolean addEntry(String name) {
        if (!hasLeftChild) {
            line++;
            hasLeftChild = true;
            leftChild = new Entry<>(name);
        } else if (!hasRigthChild) {
            hasRigthChild = true;
            rigthChild = new Entry<>(name);
        } else {
            leftChild.addEntry(name);
            line++;
            leftChild.hasLeftChild=true;
        }
        return true;
    }
}
