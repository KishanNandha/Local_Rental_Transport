package com.LRT.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.LRT.dao.BookingDAO;
import com.LRT.dao.CycleDAO;
import com.LRT.dao.StartRideDAO;
import com.LRT.model.Bookings;
import com.LRT.model.Cycles;
import com.LRT.model.StartRide;

@Service("startrideservice")
@Transactional
public class StartRideService {

	@Autowired
	StartRideDAO startridedao;

	@Autowired
	BookingDAO bookingdao;

	@Autowired
	CycleDAO cycledao;


	@Transactional
	public StartRide getStartRidebyid(int startrideid) {

		return startridedao.getStartRideById(startrideid);
	}

	@Transactional
	public void addstartride(StartRide startride)
	{
		startridedao.addStartRide(startride);
	}

	@Transactional
	public List<String> getcycles() {
		List<Cycles> cyclelist = cycledao.listCycles();

		List cyclenames = new ArrayList();
		for (Cycles c : cyclelist) {
			cyclenames.add(c.getCycleId());
		}
		return cyclenames;
	}

	@Transactional
	public void addstartridewithbookingid(StartRide startride) {
		startridedao.addStartRide(startride);
		Bookings booking = bookingdao.getBookingsByName(startride.getUserName());
		bookingdao.removeBooking(booking);
	}
}
