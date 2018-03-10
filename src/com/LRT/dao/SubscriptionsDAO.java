package com.LRT.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.LRT.model.Subscriptions;

@Repository
public class SubscriptionsDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public Subscriptions getSubscriptionsById(int subscriptionid) {
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.get(Subscriptions.class, subscriptionid);
	}

	public boolean addsubscription(Subscriptions subscription) {
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.save(subscription);
			return true;
		} catch (Exception ex) {

			return false;
		}

	}

	public boolean updatesubscription(Subscriptions subscription) {
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.update(subscription);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	public boolean removesubscription(Subscriptions subscription) {
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.delete(subscription);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	public List<Subscriptions> listSubscriptions() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Subscriptions> subscriptionList = session.createQuery("from Subscriptions").list();
		return subscriptionList;
	}

}
