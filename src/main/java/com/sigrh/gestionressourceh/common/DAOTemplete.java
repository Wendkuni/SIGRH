package com.sigrh.gestionressourceh.common;


import java.util.List;

public interface DAOTemplete<T> {
	
	boolean create(T obj);
	
	boolean delete(T obj);

	boolean update(T obj);

	T find(int id);

	List<T> findAll();

	
}
