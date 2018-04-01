package com.LRT.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.LRT.model.vo.Transactions;

@Repository("transdao")
@Transactional
public class TransDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public Transactions getTransById(int transid) {

		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.get(Transactions.class, transid);
	}



	@Transactional
	public boolean addTrans(Transactions trans) {
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.save(trans);
			return true;
		} catch (Exception ex) {

			return false;
		}

	}
	@Transactional
	public List<Transactions> listTrans() {
		Session session = sessionFactory.getCurrentSession();
		List<Transactions> bookingList = session.createQuery("from Transactions").list();
		return bookingList;

	}

	@Transactional
	public List<Transactions> listTransOfUser(String username) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Transactions.class);
		Criterion criterion = Restrictions.eq("userName", username);
		criteria.add(criterion);
		List<Transactions> bookingList = criteria.list();
		return bookingList;

	}


}
