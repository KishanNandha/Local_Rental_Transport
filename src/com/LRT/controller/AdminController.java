package com.LRT.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.LRT.ApplicationConstants.ViewConstants;
import com.LRT.model.vo.Finance;
import com.LRT.service.AdminService;
import com.LRT.service.BookingService;
import com.LRT.service.EtartRideService;
import com.LRT.service.StartRideService;

@Controller
@RequestMapping(value = { "/admin" })
public class AdminController {

	@Autowired
	private AdminService adminservice;
	@Autowired
	private BookingService bookingservice;
	@Autowired
	private StartRideService startrideservice;
	@Autowired
	private EtartRideService endrideservice;
	@Autowired
	private com.LRT.service.UserDetailsSevice userdetailsservice;
	@Autowired
	HttpSession httpSession;

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {

		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	public void commonService() {
		com.LRT.model.UserDetails userDetails = bookingservice.getDetailsofUser(getPrincipal());
		httpSession.setAttribute("sessionuser", getPrincipal());
		httpSession.setAttribute("loginBean", userDetails);

	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String adminPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());

		return ViewConstants.ADMINHOME;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		model.addAttribute("msg", "You've been logged outsuccessfully.");
		return "login";
	}

	@RequestMapping(value = "/viewallridesofstorepanel", method = RequestMethod.GET)
	public String ViewAllRideOfStore(ModelMap model) {
		commonService();
		model.addAttribute("storeslist", bookingservice.getstores());
		return ViewConstants.CROVIEWALLRIDEOFSTOREPANEL;
	}


	@RequestMapping(value = "/viewalluserdetailspanel", method = RequestMethod.GET)
	public String ViewAllUserDetails(ModelMap model) {
		return ViewConstants.CROVIEWALLUSERDETAILSPANELS;
	}

	@RequestMapping(value = "/viewalluserdetails")
	public String ViewAllUserDetailsPage(ModelMap model, HttpServletRequest request) {
		model.addAttribute("userdetails", (userdetailsservice).getUserDatails(request.getParameter("username")));
		return ViewConstants.CROVIEWALLUSERDETAILS;
	}

	@RequestMapping(value = "/viewallridesofuserpanel", method = RequestMethod.GET)
	public String ViewAllRideOfuser(ModelMap model) {
		return ViewConstants.CROVIEWALLUSERRIDEPANEL;
	}

	@RequestMapping(value = "/viewallrideofuser")
	public String ViewAllRideOfuserPage(ModelMap model, HttpServletRequest request) {
		model.addAttribute("ridelist", endrideservice.getAllRideDetailsForUser(request.getParameter("username")));
		return ViewConstants.CROVIEWALLUSERRIDE;
	}

	@RequestMapping(value = "/viewallrideofstore")
	public String ViewAllRideOfStorePage(ModelMap model, HttpServletRequest request) {
		commonService();
		model.addAttribute("startridelist", endrideservice.getAllStartRideDetails(request.getParameter("storename")));
		model.addAttribute("endridelist", endrideservice.getAllEndRideDetails(request.getParameter("storename")));
		return ViewConstants.CROVIEWALLRIDEOFSTORE;
	}

	@RequestMapping(value = "/reg")
	public String reg(ModelMap model) {
		commonService();
		com.LRT.model.UserDetails userdata = new com.LRT.model.UserDetails();
		model.addAttribute("userdata", userdata);
		return ViewConstants.CROREG;
	}

	@RequestMapping(value = "/doreg", method = RequestMethod.POST)
	public String doreg(HttpServletRequest request, ModelMap model,
			@Valid @ModelAttribute("userdata") com.LRT.model.UserDetails userdata, BindingResult theBindingResult) {
		commonService();
		if (theBindingResult.hasErrors()) {
			return ViewConstants.CROREG;
		} else {
			if (userdetailsservice.chkUser(userdata.getUserName())) {
				model.addAttribute("regfailed", 0);
				userdetailsservice.addUserDatails(userdata, request.getParameter("password"));
				return ViewConstants.CROREGCONFORM;
			} else {
				model.addAttribute("regfailed", 1);
				return ViewConstants.CROREG;
			}
		}

	}

	@RequestMapping(value = "/changehourlyratepanel", method = RequestMethod.GET)
	public String hr(ModelMap model) {
		httpSession.setAttribute("hourlyRate", endrideservice.getHourlyRate());
		return ViewConstants.ADMINHOURLY;
	}

	@RequestMapping(value = "/changehourlyrate")
	public String chr(ModelMap model, HttpServletRequest request) {
		int rate = Integer.parseInt(request.getParameter("rate"));
		Finance f = new Finance();
		f.setHourlyRate(rate);
		adminservice.updatehourlyrate(f);
		httpSession.setAttribute("hourlyRate", endrideservice.getHourlyRate());
		return ViewConstants.ADMINHOURLY;
	}

	private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
}
