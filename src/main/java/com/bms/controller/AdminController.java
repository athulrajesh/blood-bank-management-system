package com.bms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



import com.bms.model.AdminModel;
import com.bms.model.BloodGroupModel;
import com.bms.model.OrderModel;
import com.bms.service.AdminService;

@Controller
public class AdminController {
	@Autowired
	AdminService service;

	@RequestMapping(value = "/adminlogin")
	public String login() {

		return "adminlogin";
	}

	@RequestMapping(value = "/login")
	public String loginAdmin( AdminModel model, Model mv, HttpServletRequest req) {
		try {
			AdminModel result = service.loginAdmin(model);
			System.out.println(model);
			if (result != null) {
				System.out.println("entered ");
				HttpSession session = req.getSession();
				session.setAttribute("admin", result);
				
				
				
				return "redirect:/admindash";
			} else {
				mv.addAttribute("msg", "invalid credentials");
				return "adminlogin";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}
	
	@RequestMapping(value="/admindash")
	public String admindash( HttpServletRequest req) {
				return "newadmindash";
	}

	@RequestMapping(value = "/status")
	public String status(Model mv) {
		try {
			BloodGroupModel model = service.getStatus();
			mv.addAttribute("obj", model);

			System.out.println(model.getId());

			return "statuspage";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}

	@RequestMapping(value = "/save")
	@ResponseBody
	public String status(BloodGroupModel model) {
		try {
			System.out.println(model);
			model.setId(1);
			service.save(model);

			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}

	@RequestMapping(value = "/dlist")

	public String donorlist() {

		return "donorlist";
	}

	@RequestMapping(value = "/manage")
	@ResponseBody
	public String manageDonors(HttpServletRequest req) {
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

	@RequestMapping(value = "/verify", method = RequestMethod.POST)
	@ResponseBody
	public List<String> verifyUser(@RequestParam(value = "id[]") List<String> tab, HttpServletRequest req) {
		System.out.println(tab);
		List<String> status = new ArrayList<String>();
		try {
			for (String str : tab) {

				service.verify(str);

				status.add("success");
			}

			return status;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return status;
		}

	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public String delete(@RequestParam(value = "id[]") List<String> tab) {
		try {
			System.out.println(tab);
			service.delete(tab);
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}

	}

	@RequestMapping(value = "/orders")

	public String orders() {

		return "orderslist";
	}

	@RequestMapping(value = "/orderslist")
	@ResponseBody
	public String orderlist(HttpServletRequest req) {
		try {
			System.out.println("hit");
			JSONObject data = null;
			int idisplaylength = Integer.parseInt(req.getParameter("iDisplayLength"));
			int displaystart = Integer.parseInt(req.getParameter("iDisplayStart"));
			String sSearch = req.getParameter("sSearch");
			String searchParam = req.getParameter("searchData");

			try {
				data = service.getOrderTable(searchParam, sSearch, displaystart, idisplaylength);
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

	@RequestMapping(value = "/deleteorder", method = RequestMethod.POST)
	@ResponseBody
	public String deleteorder(@RequestParam(value = "id[]") List<String> tab) {
		try {
			System.out.println(tab);
			BloodGroupModel bgmodel = service.getStatus();
			for (String order : tab) {
				int o = Integer.parseInt(order);
				OrderModel om = service.getOrder(o);
				String bg = om.getBg();
				float amount = om.getAmount();
				float temp = 0;
				switch (bg) {
				case "aPos":
					temp = bgmodel.getaPos();
					System.out.println(temp);
					bgmodel.setaPos(temp + amount);
					break;
				case "aNeg":
					temp = bgmodel.getaNeg();
					bgmodel.setaNeg(temp + amount);
					break;
				case "oPos":
					temp = bgmodel.getoPos();
					bgmodel.setoPos(temp + amount);
					break;
				case "oNeg":
					temp = bgmodel.getoNeg();
					bgmodel.setoNeg(temp + amount);
					break;
				case "bPos":
					temp = bgmodel.getbPos();
					bgmodel.setbPos(temp + amount);
					break;
				case "bNeg":
					temp = bgmodel.getbNeg();
					bgmodel.setbNeg(temp + amount);
					break;
				case "abPos":
					temp = bgmodel.getAbPos();
					bgmodel.setAbPos(temp + amount);
					break;
				case "abNeg":
					temp = bgmodel.getAbNeg();
					bgmodel.setAbNeg(temp + amount);
					break;
				default:
					System.out.println("something wrong");
				}
				service.save(bgmodel);

				service.deleteorder(o);
			}
			return "success";
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return"";
		}

	}

	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest req) {

		req.getSession().setAttribute("admin", null);
		

		return "adminlogin";
	}

}
