package com.bms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.dao.DonorDao;
import com.bms.model.DonorModel;

@Service
public class DonorServiceImpl implements DonorService {
	@Autowired
	DonorDao dao;

	@Override
	public DonorModel loginDonor(DonorModel model) {
		
		return dao.loginDonor(model);
	}

	@Override
	public DonorModel getDonor(String username) {
		
		return dao.getDonor(username);
	}

	@Override
	public void update(DonorModel model) {
		dao.update(model);
		
	}

	@Override
	public void save(DonorModel model) {
		dao.save(model);
		
	}

	@Override
	public DonorModel check(String user) {
		
		return dao.check(user);
	}

}
