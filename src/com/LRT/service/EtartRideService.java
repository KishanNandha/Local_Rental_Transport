package com.LRT.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.LRT.dao.BookingDAO;
import com.LRT.dao.CycleDAO;
import com.LRT.dao.EndRideDAO;
import com.LRT.dao.StartRideDAO;
import com.LRT.model.EndRide;

@Service("endrideservice")
@Transactional
public class EtartRideService {

	@Autowired
	StartRideDAO startridedao;

	@Autowired
	EndRideDAO endridedao;

	@Autowired
	BookingDAO bookingdao;

	@Autowired
	CycleDAO cycledao;



	@Transactional
	public void addendride(EndRide endride)
	{
		endridedao.addEndRide(endride);
	}

}
