package com.LRT.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.LRT.dao.UserLoginDAO;
import com.LRT.model.Userlogin;

@Service
public class TestService {

	@Autowired
	private UserLoginDAO userlogindao;

	@Transactional
	public void serviceinsert(Userlogin userlogin) {
		userlogindao.daoinsert(userlogin);
	}

	@Transactional
	public void servicedelete(Userlogin userlogin) {
		userlogindao.daodelete(userlogin);
	}

	@Transactional
	public void serviceupdate(Userlogin userlogin) {
		userlogindao.daoupdate(userlogin);
	}
}
