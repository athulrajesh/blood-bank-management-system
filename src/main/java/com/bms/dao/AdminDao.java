package com.bms.dao;

import java.util.List;

import com.bms.model.AdminModel;
import com.bms.model.BloodGroupModel;
import com.bms.model.DonorModel;
import com.bms.model.OrderModel;

public interface AdminDao {
	public AdminModel loginAdmin(AdminModel model);

	public BloodGroupModel getStatus();

	public void save(BloodGroupModel model);

	public List<DonorModel> searchUserDetails(String searchParam, String sSearch, int displaystart, int idisplaylength);

	public long getRecordCountForUser(String searchParam, String sSearch);

	public void verify(String str);

	public void delete(List<String> tab);

	public List<OrderModel> searchOrderDetails(String searchParam, String sSearch, int displaystart,
			int idisplaylength);

	public long getRecordCountForOrder(String searchParam, String sSearch);

	

	public OrderModel getOrder(int order);

	void deleteorder(int o);

}
