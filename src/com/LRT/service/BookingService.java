package com.LRT.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.LRT.dao.BookingDAO;
import com.LRT.dao.StoresDAO;
import com.LRT.model.Bookings;
import com.LRT.model.Stores;

@Service("bookingservice")
@Transactional
public class BookingService {

	@Autowired
	StoresDAO storedao;
	@Autowired
	BookingDAO bookingdao;

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
}
