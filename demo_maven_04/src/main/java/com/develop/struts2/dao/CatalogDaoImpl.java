package com.develop.struts2.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.develop.struts2.model.Catalog;

@Repository("CatalogDao")
public class CatalogDaoImpl implements CatalogDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Catalog> searchCatalog(String name) {
		return (List<Catalog>) sessionFactory.getCurrentSession().createCriteria(Catalog.class)
				.add(Restrictions.like("name", "%" + name + "%")).addOrder(Order.asc("id")).list();
	}

	public void addCatalog(Catalog model) {
		try {
			sessionFactory.getCurrentSession().save(model);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateCatalog(Catalog model) {
		try {
			sessionFactory.getCurrentSession().update(model);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void deleteCatalog(Long id) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Catalog object = (Catalog) session.get(Catalog.class, id);
			session.delete(object);

			// This makes the pending delete to be done
			session.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	public List<Catalog> listCatalog() {
		return (List<Catalog>) sessionFactory.getCurrentSession().createCriteria(Catalog.class).list();
	}

	public void saveOrUpdateCatalog(Catalog model) {
		try {
			if(model.getId() == null)
				sessionFactory.getCurrentSession().save(model);
			else {
				Session session = sessionFactory.openSession();
			    Transaction tx = session.beginTransaction();

			    //update/insert operations here

			    session.update(model);

			    tx.commit();

			    session.close();
				
			}
			//sessionFactory.getCurrentSession().saveOrUpdate(model);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Catalog searchCatalogById(Long id) {
		Catalog catalog = null;
		try {
			catalog = (Catalog) sessionFactory.getCurrentSession().get(Catalog.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return catalog;
	}

}
