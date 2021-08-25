package com.ngoc.tour.repository;

import java.util.List;

public interface DAO<T> {
	
	List<T> getList();
    T findById(Long id);
    void insert(T vo);
    void update(T vo);
    void delete(Long id);

}
