package com.develop.struts2.dao;

import java.util.List;

import com.develop.struts2.model.Catalog;

public interface CatalogDao {
	List<Catalog> listCatalog();
	List<Catalog> searchCatalog(String name);
	Catalog searchCatalogById(Long id);
	
	void addCatalog(Catalog model);
	void updateCatalog(Catalog model);
	void deleteCatalog(Long id);
	void saveOrUpdateCatalog(Catalog model);
}
