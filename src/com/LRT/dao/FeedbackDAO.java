package com.LRT.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.LRT.model.Feedbacks;

@Repository
public class FeedbackDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public Feedbacks getFeedbacksById(int feedbackid) {
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.get(Feedbacks.class, feedbackid);
	}

	public boolean addfeedback(Feedbacks feedback) {
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.save(feedback);
			return true;
		} catch (Exception ex) {

			return false;
		}

	}

	public boolean updatefeedback(Feedbacks feedback) {
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.update(feedback);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	public boolean removefeedback(Feedbacks feedback) {
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.delete(feedback);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	public List<Feedbacks> listFeedbacks() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Feedbacks> feedbackList = session.createQuery("from Feedbacks").list();
		return feedbackList;
	}

}
