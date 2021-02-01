package com.bms.service;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bms.dao.ReceiverDao;
import com.bms.model.BloodGroupModel;
import com.bms.model.DonorModel;
import com.bms.model.OrderModel;

@Service
public class ReceiverServiceImpl implements ReceiverService{
	@Autowired
	ReceiverDao dao;

	public BloodGroupModel getStatus() {
		
		return dao.getStatus();
	}

	public void book(OrderModel model) {
		model.setTime();
		dao.book(model);
		
	}

	@Override
	public void updateStatus(BloodGroupModel bgmodel) {
		dao.updateStatus(bgmodel);
		
	}

	@Override
	public OrderModel getorder(int order) {
		
		return dao.getorder(order);
	}

	@Override
	public JSONObject getDataTable(String searchParam, String sSearch, int displaystart, int idisplaylength) {
		JSONObject res = new JSONObject();
		JSONArray userArray = new JSONArray();
		List<DonorModel> userList = null;
		long rowCount = 0;
		JSONObject userObj =null;
		try {
			userList = dao.searchUserDetails(searchParam, sSearch, displaystart, idisplaylength);
			System.out.println(userList);
				rowCount = dao.getRecordCountForUser(searchParam, sSearch);
			if (userList != null) {
				for (DonorModel user : userList) {
				    userObj = new JSONObject();
					// ----------put your data here--------------------
					userObj.put("username", user.getUsername());
					userObj.put("name", user.getName());
					userObj.put("bg", user.getBg());
					userObj.put("age", user.getAge());
					
					userObj.put("weight", user.getWeight());
					userObj.put("sex", user.getSex());
					userObj.put("phone", user.getPhone());
					userObj.put("email", user.getEmail());
					userObj.put("location", user.getLocation());
					
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

}
