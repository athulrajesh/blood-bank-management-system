package com.bms.service;

import org.json.JSONObject;

import com.bms.model.BloodGroupModel;
import com.bms.model.OrderModel;

public interface ReceiverService {

public 	BloodGroupModel getStatus();

public void book(OrderModel model);

public void updateStatus(BloodGroupModel bgmodel);

public OrderModel getorder(int order);

public JSONObject getDataTable(String searchParam, String sSearch, int displaystart, int idisplaylength);

}
