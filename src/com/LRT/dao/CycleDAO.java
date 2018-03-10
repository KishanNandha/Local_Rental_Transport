package com.LRT.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.LRT.model.Cycles;

@Repository("cycledao")
public class CycleDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public Cycles getCyclesById(int Cycleid) {
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.get(Cycles.class, Cycleid);
	}

	public boolean addCycle(Cycles Cycle) {
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.save(Cycle);
			return true;
		} catch (Exception ex) {

			return false;
		}

	}

	public boolean updateCycle(Cycles Cycle) {
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.update(Cycle);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	public boolean removeCycle(Cycles Cycle) {
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.delete(Cycle);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	public List<Cycles> listCycles() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Cycles> cycleList = session.createQuery("from Cycles").list();
		return cycleList;
	}

}
