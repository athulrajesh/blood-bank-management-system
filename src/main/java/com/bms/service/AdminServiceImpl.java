package com.bms.service;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.dao.AdminDao;
import com.bms.model.AdminModel;
import com.bms.model.BloodGroupModel;
import com.bms.model.DonorModel;
import com.bms.model.OrderModel;

@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	AdminDao admin;

	public AdminModel loginAdmin(AdminModel model) {
		AdminModel result = admin.loginAdmin(model);
		
		
		
		return result;
	}

	public BloodGroupModel getStatus() {
		
		return admin.getStatus();
	}

	public void save(BloodGroupModel model) {
		admin.save(model);
		
	}
	
	
	
	public JSONObject getDataTable(String searchParam, String sSearch, int displaystart, int idisplaylength) {
		JSONObject res = new JSONObject();
		JSONArray userArray = new JSONArray();
		List<DonorModel> userList = null;
		long rowCount = 0;
		JSONObject userObj =null;
		try {
			userList = admin.searchUserDetails(searchParam, sSearch, displaystart, idisplaylength);
			System.out.println(userList);
				rowCount = admin.getRecordCountForUser(searchParam, sSearch);
			if (userList != null) {
				for (DonorModel user : userList) {
				    userObj = new JSONObject();
					// ----------put your data here--------------------
					userObj.put("username", user.getUsername());
					userObj.put("name", user.getName());
					userObj.put("bg", user.getBg());
					userObj.put("age", user.getAge());
					userObj.put("status", user.getStatus());
					userObj.put("weight", user.getWeight());
					userObj.put("sex", user.getSex());
					userObj.put("phone", user.getPhone());
					userObj.put("email", user.getEmail());
					userObj.put("location", user.getLocation());
					userObj.put("verified", user.getVerified());
					userObj.put("verified", user.getVerified());
					userObj.put("sex", user.getSex());
					
					
					userArray.put(userObj);
				}
				res.put("aaData", userArray);
				res.put("iTotalDisplayRecords", rowCount);
				res.put("iTotalRecords", rowCount);
			} else {
				res.put("aaData", userArray);
				res.put("iTotalDisplayRecords", 0);
				res.put("iTotalRecords", 0);

			}

		} catch (Exception e) {
			//logger.error(e.getMessage(), e);
			//throw new ProcessingException(e.getMessage());
		}
		return res;
	

	}

	public void verify(String str) {
		admin.verify(str);
		
	}

	public void delete(List<String> tab) {
		admin.delete(tab);
		
	}

	@Override
	public JSONObject getOrderTable(String searchParam, String sSearch, int displaystart, int idisplaylength) {
		JSONObject res = new JSONObject();
		JSONArray userArray = new JSONArray();
		List<OrderModel> userList = null;
		long rowCount = 0;
		JSONObject userObj =null;
		try {
			userList = admin.searchOrderDetails(searchParam, sSearch, displaystart, idisplaylength);
			System.out.println(userList);
				rowCount = admin.getRecordCountForOrder(searchParam, sSearch);
			if (userList != null) {
				for (OrderModel user : userList) {
				    userObj = new JSONObject();
					// ----------put your data here--------------------
					userObj.put("order_id", user.getOrder_id());
					userObj.put("bg", user.getBg());
					userObj.put("amount", user.getAmount());
					userObj.put("time", user.getTime());
					
					
					
					userArray.put(userObj);
					System.out.println(userObj);
				}
				res.put("aaData", userArray);
				res.put("iTotalDisplayRecords", rowCount);
				res.put("iTotalRecords", rowCount);
			} else {
				res.put("aaData", userArray);
				res.put("iTotalDisplayRecords", 0);
				res.put("iTotalRecords", 0);

			}

		} catch (Exception e) {
			//logger.error(e.getMessage(), e);
			//throw new ProcessingException(e.getMessage());
		}
		return res;
	}

	@Override
	public void deleteorder(int tab) {
		admin.deleteorder(tab);
		
	}

	@Override
	public OrderModel getOrder(int order) {
		
		return admin.getOrder(order);
	}

}
