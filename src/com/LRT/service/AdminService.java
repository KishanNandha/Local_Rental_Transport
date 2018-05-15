package com.LRT.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.LRT.dao.AdminDAO;
import com.LRT.model.vo.Finance;

@Service("adminservice")
@Transactional
public class AdminService {

	@Autowired
	AdminDAO admindao;


	@Transactional
	public Finance gethourlyrate() {
		return admindao.gethourlyrate();
	}

	@Transactional
	public void updatehourlyrate(Finance f) {
		admindao.updatehourlyrate(f);
	}
}
