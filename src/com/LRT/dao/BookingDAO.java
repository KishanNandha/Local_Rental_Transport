package com.LRT.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.LRT.model.Bookings;

@Repository("bookingdao")
@Transactional
public class BookingDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public Bookings getBookingsById(int bookingid) {

		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.get(Bookings.class, bookingid);
	}

	public Bookings getBookingsByName(String username) {
		Session currentSession = sessionFactory.getCurrentSession();
		Criteria criteria = currentSession.createCriteria(Bookings.class);
		Criterion criterion = Restrictions.eq("userName", username);
		criteria.add(criterion);
		Bookings booking = (Bookings) criteria.uniqueResult();
		System.out.println(booking);
		return booking;
	}

	@Transactional
	public boolean addBooking(Bookings booking) {
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.save(booking);
			return true;
		} catch (Exception ex) {

			return false;
		}

	}

	@Transactional
	public boolean updateBooking(Bookings booking) {
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.update(booking);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	@Transactional
	public boolean removeBooking(Bookings booking) {
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			System.out.println("deletinmg" + booking);
			currentSession.delete(booking);
			return true;
		} catch (HibernateException e) {
			return false;
		}
	}

	@Transactional
	public List<Bookings> listBookings() {
		Session session = sessionFactory.getCurrentSession();
		List<Bookings> bookingList = session.createQuery("from Bookings").list();
		return bookingList;

	}


}
