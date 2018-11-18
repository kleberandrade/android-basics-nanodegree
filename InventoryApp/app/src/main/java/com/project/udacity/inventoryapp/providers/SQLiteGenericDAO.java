package com.project.udacity.inventoryapp.providers;

import java.util.List;

interface SQLiteGenericDAO<T> {

    long create(T t);
    void update(T t);
    void delete(T t);
    T searchById(long id);
    List<T> searchAll();

}