package com.LRT.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.LRT.dao.BookingDAO;
import com.LRT.dao.CycleDAO;
import com.LRT.dao.EndRideDAO;
import com.LRT.dao.RideDetailsDAO;
import com.LRT.dao.StartRideDAO;
import com.LRT.dao.TransDAO;
import com.LRT.model.EndRide;
import com.LRT.model.RideDetails;
import com.LRT.model.StartRide;
import com.LRT.model.DTO.RideAllDetails;
import com.LRT.model.vo.Transactions;

@Service("endrideservice")
@Transactional
// this is be endrideservice ignore name of class
public class EtartRideService {

	@Autowired
	StartRideDAO startridedao;

	@Autowired
	EndRideDAO endridedao;

	@Autowired
	BookingDAO bookingdao;

	@Autowired
	CycleDAO cycledao;

	@Autowired
	RideDetailsDAO rideDetailsDAO;

	@Autowired
	TransDAO transdao;

	@Autowired
	HttpSession httpSession;

	@Transactional
	public void addendride(EndRide endride, StartRide startRide)
	{
		endridedao.addEndRide(endride);
		RideDetails ridedetails=new RideDetails();
		ridedetails.setEndRideId(endride.getEndRideId());
		ridedetails.setStartRideId(startRide.getStartRideId());
		ridedetails.setUsername(startRide.getUserName());
		Transactions tran = new Transactions();
		tran.setEndRideId(endride.getEndRideId());
		tran.setEndStoreName(endride.getEndStoreName());
		tran.setUserName(startRide.getUserName());
		tran.setTotalTime(endride.getTotalTime());
		tran.setTotalAmount(endride.getTotalAmount());
		tran.setDate(startRide.getDepartureDate());
		transdao.addTrans(tran);
		rideDetailsDAO.addRideDetails(ridedetails);
	}

	@Transactional
	public boolean chkEndRide(EndRide endride) {

		List<EndRide> list = endridedao.listEndRide();
		if (list.size() >= 1) {
			int flag = 0;
			for (EndRide b : list) {
				if (b.equals(endride)) {
					flag = 1;
				}
				if (endride.getStartRideId() == b.getStartRideId()) {
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

	@Transactional
	public List<EndRide> ListEndRide() {

		return endridedao.listEndRide();
	}

	@Transactional
	public List<RideAllDetails> getAllEndRideDetails(String storename) {
		List<EndRide> endridelist = endridedao.listEndRideByStore(storename);
		List<RideAllDetails> list = new ArrayList<RideAllDetails>();
		for (EndRide endride : endridelist) {
			RideAllDetails ridealldetails = new RideAllDetails();
			StartRide startride = startridedao.getStartRideById(endride.getStartRideId());
			// set startride details
			ridealldetails.setStartRideId(startride.getStartRideId());
			ridealldetails.setUserName(startride.getUserName());
			ridealldetails.setStartStoreName(startride.getStartStoreName());
			ridealldetails.setDepartureDate(startride.getDepartureDate());
			ridealldetails.setDepartureTime(startride.getDepartureTime());
			ridealldetails.setEstimatedEndTime(startride.getEstimatedEndTime());
			ridealldetails.setCycleId(startride.getCycleId());
			// set end ride details
			ridealldetails.setEndRideId(endride.getEndRideId());
			ridealldetails.setEndTime(endride.getEndTime());
			ridealldetails.setEndStoreName(endride.getEndStoreName());
			ridealldetails.setTotalAmount(endride.getTotalAmount());
			ridealldetails.setTotalTime(endride.getTotalTime());
			ridealldetails.setAnyDamage(endride.getAnyDamage());

			// add object in list
			list.add(ridealldetails);
		}
		return list;
	}

	@Transactional
	public List<RideAllDetails> getAllStartRideDetails(String storename) {
		List<StartRide> startridelist = startridedao.listStartRideByStore(storename);
		List<RideAllDetails> list = new ArrayList<RideAllDetails>();
		for (StartRide startride : startridelist) {
			RideAllDetails ridealldetails = new RideAllDetails();
			// set startride details
			ridealldetails.setStartRideId(startride.getStartRideId());
			ridealldetails.setUserName(startride.getUserName());
			ridealldetails.setStartStoreName(startride.getStartStoreName());
			ridealldetails.setDepartureDate(startride.getDepartureDate());
			ridealldetails.setDepartureTime(startride.getDepartureTime());
			ridealldetails.setEstimatedEndTime(startride.getEstimatedEndTime());
			ridealldetails.setCycleId(startride.getCycleId());
			// set end ride details
			EndRide endride = endridedao.getEndRideByStartRide(startride.getStartRideId());
			if (endride != null) {
				ridealldetails.setEndRideId(endride.getEndRideId());
				ridealldetails.setEndTime(endride.getEndTime());
				ridealldetails.setEndStoreName(endride.getEndStoreName());
				ridealldetails.setTotalAmount(endride.getTotalAmount());
				ridealldetails.setTotalTime(endride.getTotalTime());
				ridealldetails.setAnyDamage(endride.getAnyDamage());
			} else {
				ridealldetails.setEndRideId(0);
				ridealldetails.setEndTime(null);
				ridealldetails.setEndStoreName(null);
				ridealldetails.setTotalAmount(0);
				ridealldetails.setTotalTime(0);
				ridealldetails.setAnyDamage(null);
			}
			// add object in list
			list.add(ridealldetails);
		}
		return list;
	}
	
	@Transactional
	public List<RideAllDetails> getAllRideDetailsForUser(String username) {
		List<StartRide> startridelist = startridedao.listStartRideOfUser(username);
		List<RideAllDetails> list = new ArrayList<RideAllDetails>();
		for (StartRide startride : startridelist) {
			RideAllDetails ridealldetails = new RideAllDetails();
			// set startride details
			ridealldetails.setStartRideId(startride.getStartRideId());
			ridealldetails.setUserName(startride.getUserName());
			ridealldetails.setStartStoreName(startride.getStartStoreName());
			ridealldetails.setDepartureDate(startride.getDepartureDate());
			ridealldetails.setDepartureTime(startride.getDepartureTime());
			ridealldetails.setEstimatedEndTime(startride.getEstimatedEndTime());
			ridealldetails.setCycleId(startride.getCycleId());
			// set end ride details
			EndRide endride = endridedao.getEndRideByStartRide(startride.getStartRideId());
			if (endride != null) {
				ridealldetails.setEndRideId(endride.getEndRideId());
				ridealldetails.setEndTime(endride.getEndTime());
				ridealldetails.setEndStoreName(endride.getEndStoreName());
				ridealldetails.setTotalAmount(endride.getTotalAmount());
				ridealldetails.setTotalTime(endride.getTotalTime());
				ridealldetails.setAnyDamage(endride.getAnyDamage());
			} else {
				ridealldetails.setEndRideId(0);
				ridealldetails.setEndTime(null);
				ridealldetails.setEndStoreName(null);
				ridealldetails.setTotalAmount(0);
				ridealldetails.setTotalTime(0);
				ridealldetails.setAnyDamage(null);
			}
			// add object in list
			list.add(ridealldetails);
		}
		return list;
	}

	public EndRide calAmount(EndRide endride, StartRide startride) {
		int totaltime = calHours(endride.getEndTime(), startride.getDepartureTime());
		endride.setTotalTime(totaltime);
		endride.setTotalAmount(totaltime * (int) httpSession.getAttribute("hourlyRate"));
		return endride;
	}

	public int calHours(String endtime, String starttime) {
		int result = 0;
		DateFormat formatter = new SimpleDateFormat("hh:mm a");
		try {
			String date1 = "26/02/2011";
			String date2 = "27/02/2011";
			String format = "dd/MM/yyyy hh:mm a";
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			Date dateObj1 = sdf.parse(date1 + " " + starttime);
			Date dateObj2 = sdf.parse(date2 + " " + endtime);
			System.out.println(dateObj1);
			System.out.println(dateObj2);
			long diff = dateObj2.getTime() - dateObj1.getTime();
			double diffInHours = diff / ((double) 1000 * 60 * 60);
			result = (int) Math.ceil(diffInHours);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 4;
	}

	public int getHourlyRate() {
		return endridedao.getHourlyRate();
	}
}
