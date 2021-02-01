package com.bms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bms.model.DonorModel;
import com.bms.service.DonorService;

@Controller
@RequestMapping(value = "/donor")
public class DonorController {
	@Autowired
	DonorService service;

	@RequestMapping(value = "/")
	public String donor() {
		return "donorlogin";

	}

	@RequestMapping(value = "/register")
	public String register() {
		return "register";

	}

	@RequestMapping(value = "/savereg")
	@ResponseBody
	public String savereg(DonorModel model) {
		try {
			if (model.getUsername() == "" || model.getEmail() == "" || model.getLocation() == "" || model.getName() == ""
					|| model.getAge() == 0 || model.getPassword() == "" || model.getWeight() == 0
					|| model.getPhone() == "") {
				return "error";
			}
			model.setVerified(0);

			service.save(model);

			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}

	}

	@RequestMapping(value = "/login")
	public String login(HttpServletRequest req, Model mv, DonorModel model) {

		try {
			HttpSession session = req.getSession();
			DonorModel result = service.loginDonor(model);
			System.out.println(result);
			if (result != null) {
				session.setAttribute("login", result);
				
				return "redirect:/donor/donordash";
			} else {
				mv.addAttribute("msg", "invalid credentials");
				return "donorlogin";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}

	}
	
	
	@RequestMapping(value="/donordash")
	public String donordash() {
		return"donordash";
	}

	@RequestMapping(value = "/update")
	@ResponseBody
	public String update(DonorModel model, HttpServletRequest req) {
		try {
			System.out.println("hit");
			if (model.getUsername() == "" || model.getEmail() == "" || model.getLocation() == "" || model.getName() == ""
					|| model.getAge() == 0 || model.getPassword() == "" || model.getWeight() == 0
					|| model.getPhone() == "") {
				return "error";
			}else {

			DonorModel obj = service.getDonor(model.getUsername());
			model.setVerified(obj.getVerified());
			model.setBg(obj.getBg());
			model.setSex(obj.getSex());
			service.update(model);
			HttpSession session = req.getSession();
			session.setAttribute("login", model);
			
			return "success"; 
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}

	}

	@RequestMapping(value = "/check")
	@ResponseBody
	public String check(@RequestParam(name = "data") String user) {
		try {
			System.out.println(user);
			if (service.check(user) != null) {
				return "error";
			} else {
				return "success";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}

	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest req) {
		req.getSession().setAttribute("login", null);
		return "donorlogin";
	}

}
