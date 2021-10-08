package com.ngoc.tour.repository;

import java.util.List;

public interface DAO<T> {
	
	List<T> getList();
    T findById(int id);
    void insert(T vo);
    void update(T vo);
    void delete(int id);

}
