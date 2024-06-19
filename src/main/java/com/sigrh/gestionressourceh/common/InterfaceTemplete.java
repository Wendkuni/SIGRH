package com.sigrh.gestionressourceh.common;

import com.sigrh.gestionressourceh.domains.personnel.PersonnelDossierScanModel;

import java.util.List;

public interface InterfaceTemplete<T> {
	
	boolean create(T obj);
	
	boolean delete(T obj);

	boolean update(T obj);

	T find(int id);

	List<T> findAll();

}
