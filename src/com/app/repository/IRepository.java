package com.app.repository;

import java.util.List;

public interface IRepository<T> {
	void add(T item);
	List<T> getAll();
}
