package com.bms.service;



import com.bms.model.DonorModel;



public interface DonorService {

public	DonorModel loginDonor(DonorModel model);

public DonorModel getDonor(String username);

public void update(DonorModel model);

public void save(DonorModel model);

public DonorModel check(String user);

}
