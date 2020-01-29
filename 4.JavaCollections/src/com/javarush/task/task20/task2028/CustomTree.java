package com.javarush.task.task20.task2028;

import java.lang.String;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/* 
Построй дерево(1)
*/
public class CustomTree<T> extends AbstractList<String> implements Serializable, Cloneable {

    Entry<String> entry;

    public CustomTree() {
        this.entry = new Entry<>();
    }

    @Override
    public boolean add(String s) {
        return entry.addEntry(s);
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public <T> T[] toArray(IntFunction<T[]> generator) {
        return null;
    }

    @Override
    public boolean removeIf(Predicate<? super String> filter) {
        return false;
    }

    @Override
    public void replaceAll(UnaryOperator<String> operator) {

    }

    @Override
    public void sort(Comparator<? super String> c) {

    }

    @Override
    public void forEach(Consumer<? super String> action) {

    }

    @Override
    public Spliterator<String> spliterator() {
        return null;
    }

    @Override
    public Stream<String> stream() {
        return null;
    }

    @Override
    public Stream<String> parallelStream() {
        return null;
    }

    @Override
    public String get(int i) {
        return null;
    }
}
