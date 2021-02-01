package com.bms.controller;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bms.model.BloodGroupModel;
import com.bms.model.OrderModel;
import com.bms.service.ReceiverService;

@Controller
@RequestMapping(value="/receiver")
public class ReceiverController {
	@Autowired
	ReceiverService service;

	@RequestMapping(value = "/")
	public String receiver() {
		return "receiver";
	}

	@RequestMapping(value = "/check")
	public String status(Model mv) {
		try {
			BloodGroupModel model = service.getStatus();
			mv.addAttribute("obj", model);

			System.out.println(model.getId());

			return "checkpage";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}

	@RequestMapping(value = "/bookslot")
	public String bookslot() {
		return "bookslot";
	}

	@RequestMapping(value = "/book")
	public String book(OrderModel model, Model mv) {
		try {
			String bg = model.getBg();
			float amount = model.getAmount();
			BloodGroupModel bgmodel = service.getStatus();
			float temp = 0;
			switch (bg) {
			case "aPos":
				temp = bgmodel.getaPos();
				System.out.println(temp);
				if(temp< amount) {
					return "fail";
				}else {
				bgmodel.setaPos(temp - amount);
				break;
				}
			case "aNeg":
				temp = bgmodel.getaNeg();
				if(temp< amount) {
					return "fail";
				}else {
				bgmodel.setaNeg(temp - amount);
				break;
				}
			case "oPos":
				temp = bgmodel.getoPos();
				if(temp< amount) {
					return "fail";
				}else {
				bgmodel.setoPos(temp - amount);
				break;
				}
			case "oNeg":
				temp = bgmodel.getoNeg();
				if(temp< amount) {
					return "fail";
				}else {
				bgmodel.setoNeg(temp - amount);
				break;
				}
			case "bPos":
				temp = bgmodel.getbPos();
				if(temp< amount) {
					return "fail";
				}else {
				bgmodel.setbPos(temp - amount);
				break;
				}
			case "bNeg":
				temp = bgmodel.getbNeg();
				if(temp< amount) {
					return "fail";
				}else {
				bgmodel.setbNeg(temp - amount);
				break;
				}
			case "abPos":
				temp = bgmodel.getAbPos();
				if(temp< amount) {
					return "fail";
				}else {
				bgmodel.setAbPos(temp - amount);
				break;
				}
			case "abNeg":
				temp = bgmodel.getAbNeg();
				if(temp< amount) {
					return "fail";
				}else {
				bgmodel.setAbNeg(temp - amount);
				break;
				}
			default:
				System.out.println("something wrong");
			}

			service.book(model);
			service.updateStatus(bgmodel);
			int order= model.getOrder_id();
			OrderModel obj =service.getorder(order);
			mv.addAttribute("obj", obj);
			return "ordersuccess";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}

	
	
	@RequestMapping(value = "/donorlist")

	public String donorlist() {

		return "recdonorlist";
	}
	
	
	
	@RequestMapping(value = "/viewlist")
	@ResponseBody
	public String viewlist(HttpServletRequest req) {
		try {
			JSONObject data = null;
			int idisplaylength = Integer.parseInt(req.getParameter("iDisplayLength"));
			int displaystart = Integer.parseInt(req.getParameter("iDisplayStart"));
			String sSearch = req.getParameter("sSearch");
			String searchParam = req.getParameter("searchData");
			System.out.println(searchParam);
			try {
				data = service.getDataTable(searchParam, sSearch, displaystart, idisplaylength);
				System.out.println(data);
			} catch (Exception e) {
				System.out.println(e);
			}
			return data.toString();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}
}
