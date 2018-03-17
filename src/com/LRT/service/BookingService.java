package com.LRT.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.LRT.dao.BookingDAO;
import com.LRT.dao.StoresDAO;
import com.LRT.dao.UserDetailsDAO;
import com.LRT.model.Bookings;
import com.LRT.model.Stores;

@Service("bookingservice")
@Transactional
public class BookingService {

	@Autowired
	StoresDAO storedao;
	@Autowired
	BookingDAO bookingdao;

	@Autowired
	UserDetailsDAO userdetailsdao;

	@Transactional
	public List<String> getstores() {
		List<Stores> storesobj=storedao.listStores();
		
		 List storenames=new ArrayList();
		 for (Stores s : storesobj) 
		 { 
			 storenames.add(s.getStoreName());
			}
		return storenames;
	}

	@Transactional
	public void addbooking(Bookings booking)
	{
		bookingdao.addBooking(booking);
	}

	@Transactional
	public Bookings getBookingbyid(int bookingid) {

		return bookingdao.getBookingsById(bookingid);
	}

	@Transactional
	public com.LRT.model.UserDetails getDetailsofUser(String username) {

		return userdetailsdao.getUserDetailsByName(username);
	}

	@Transactional
	public List<Bookings> getBookingsByUsername(String username) {

		return bookingdao.listBookingsOfUser(username);
	}

	@Transactional
	public void deletebooking(Bookings booking) {

		bookingdao.removeBooking(booking);
	}

	@Transactional
	public boolean chkBooking(Bookings booking) {

		List<Bookings> list = bookingdao.listBookingsOfUser(booking.getUserName());
		if (list.size() >= 1) {
		int flag = 0;
			for (Bookings b : list) {
			if (b.equals(booking)) {
				flag = 1;
				}
			}
		if (flag == 0) {
			return true;
		} else {
			return false;
		}
		} else {
			return true;
		}
	}
}
