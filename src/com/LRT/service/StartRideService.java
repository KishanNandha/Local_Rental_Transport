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
	public void addstartridewithbookingid(int bookingid, StartRide startride) {
		startridedao.addStartRide(startride);
		Bookings booking = bookingdao.getBookingsById(bookingid);
		bookingdao.removeBooking(booking);
	}

	@Transactional
	public List<StartRide> getStartRideByUsername(String username) {

		return startridedao.listStartRideOfUser(username);
	}

	@Transactional
	public List<StartRide> ListStartRide() {

		return startridedao.listStartRide();
	}

	@Transactional
	public void removeStartRide(int id) {

		startridedao.removeStartRide(startridedao.getStartRideById(id));
	}

	@Transactional
	public boolean chkStartRide(StartRide startride) {

		List<StartRide> list = startridedao.listStartRideOfUser(startride.getUserName());
		if (list.size() >= 1) {
			int flag = 0;
			for (StartRide b : list) {
				if (b.equals(startride)) {
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
