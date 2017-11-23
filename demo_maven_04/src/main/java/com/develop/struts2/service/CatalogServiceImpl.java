package com.develop.struts2.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.develop.struts2.dao.CatalogDao;
import com.develop.struts2.model.Catalog;

@Service("catalogService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CatalogServiceImpl implements CatalogService {

	@Autowired
	private CatalogDao dao;

	public List<Catalog> listCatalog() {
		return dao.listCatalog();
	}

	public List<Catalog> searchCatalog(String name) {
		return dao.searchCatalog(name);
	}

	public void addCatalog(Catalog model) {
		dao.addCatalog(model);
	}

	public void updateCatalog(Catalog model) {
		// TODO Auto-generated method stub

	}

	public void deleteCatalog(Long id) {
		// TODO Auto-generated method stub
		dao.deleteCatalog(id);
	}

	public void saveOrUpdateCatalog(Catalog model) {
		dao.saveOrUpdateCatalog(model);
		
	}

	public Catalog searchCatalogById(Long id) {
		return dao.searchCatalogById(id);
	}

}
