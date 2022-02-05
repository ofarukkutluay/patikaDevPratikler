package com.company;

import java.util.List;

public interface ProductService<T extends Product>  {
    boolean create(T entity);
    List<T> getAll();
    T getById(int id);
    boolean delete(int id);
}
