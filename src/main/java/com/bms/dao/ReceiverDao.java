package com.bms.dao;

import java.util.List;

import com.bms.model.BloodGroupModel;
import com.bms.model.DonorModel;
import com.bms.model.OrderModel;

public interface ReceiverDao {

public	BloodGroupModel getStatus();

public void book(OrderModel model);

public void updateStatus(BloodGroupModel bgmodel);

public OrderModel getorder(int order);

public List<DonorModel> searchUserDetails(String searchParam, String sSearch, int displaystart, int idisplaylength);

public long getRecordCountForUser(String searchParam, String sSearch);

}
