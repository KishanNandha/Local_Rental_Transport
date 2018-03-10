package com.LRT.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.LRT.model.Stores;

@Repository("storedao")
@Transactional
public class StoresDAO {

	@Autowired
	private SessionFactory sessionFactory;


	public Stores getStoresById(int storeid) {
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.get(Stores.class, storeid);
	}


	public boolean addstore(Stores store) {
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.save(store);
			return true;
		} catch (Exception ex) {

			return false;
		}

	}


	public boolean updatestore(Stores store) {
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.update(store);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}


	public boolean removestore(Stores store) {
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.delete(store);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}


	public List<Stores> listStores() {
		Session currentSession = sessionFactory.getCurrentSession();
		List<Stores> storeList = currentSession.createCriteria(Stores.class).list();
		System.out.println("dao:" + storeList);
		return storeList;
	}

}
