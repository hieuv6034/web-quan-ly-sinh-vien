package com.quanlysinhvien.service;

import java.util.List;

public interface IGenericService<T> {
    Long insert(T t);
    void update(T t);
    void delete(Long id);
}
