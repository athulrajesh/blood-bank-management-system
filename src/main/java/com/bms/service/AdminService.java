package com.bms.service;

import java.util.List;

import org.json.JSONObject;

import com.bms.model.AdminModel;
import com.bms.model.BloodGroupModel;
import com.bms.model.OrderModel;

public interface AdminService {
public AdminModel loginAdmin(AdminModel model);

public BloodGroupModel getStatus();

public void save(BloodGroupModel model);

public JSONObject getDataTable(String searchParam, String sSearch, int displaystart, int idisplaylength);

public void verify(String str);

public void delete(List<String> tab);

public JSONObject getOrderTable(String searchParam, String sSearch, int displaystart, int idisplaylength);

public void deleteorder(int tab);

public OrderModel getOrder(int o);
}
