package com.reddit.datalibrary.frontpage.requests.models.v2;

import java.util.List;

public interface Listing<T> extends Iterable<T> {
    void add(Listing<? extends T> listing);

    boolean contains(T t);

    Listing<T> copy();

    T get(int i);

    String getAdDistance();

    String getAfter();

    List<T> getEntities();

    <U extends T> void insert(int i, U u);

    boolean isEmpty();

    void remove(int i);

    int size();
}
