package com.LRT.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.LRT.model.vo.Finance;

@Repository("admindao")
@Transactional
public class AdminDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public Finance gethourlyrate() {
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.get(Finance.class, 1);
	}

	@Transactional
	public void updatehourlyrate(Finance f) {
		f.setFid(1);
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.update(f);
	}

}
