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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.LRT.ApplicationConstants.ViewConstants;
import com.LRT.model.EndRide;
import com.LRT.model.StartRide;
import com.LRT.service.BookingService;
import com.LRT.service.EtartRideService;
import com.LRT.service.StartRideService;

@Controller
@RequestMapping(value = "/cro")
@Transactional
public class CroController {
	@Autowired
	private BookingService bookingservice;
	@Autowired
	private StartRideService startrideservice;
	@Autowired
	private EtartRideService endrideservice;

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {

		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@RequestMapping(value = "/home")
	public String homePage(ModelMap model, HttpSession httpsession) {
		httpsession.setAttribute("sessionuser", getPrincipal());

		return ViewConstants.CRODASHBOARD;
	}

	@RequestMapping(value = "/startridewithoutbooking")
	public String startRidewithoutbooking(ModelMap model) {
		StartRide startRide = new StartRide();
		model.addAttribute("startride", startRide);
		model.addAttribute("storeslist", bookingservice.getstores());
		model.addAttribute("cyclelist", startrideservice.getcycles());
		return ViewConstants.CROSTARTRIDEWITHOUTBOOKINGPAGE;
	}


	@RequestMapping(value = "/doaddridewithoutbooking", method = RequestMethod.POST)
	public String Dostart(ModelMap model, @Valid @ModelAttribute("startride") StartRide startride,
			BindingResult theBindingResult) {
		if (theBindingResult.hasErrors()) {
			return ViewConstants.CROSTARTRIDEWITHOUTBOOKINGPAGE;
		} else {
			if (startrideservice.chkStartRide(startride)) {
				startrideservice.addstartride(startride);
				model.addAttribute("startridefailed", 0);
				model.addAttribute("startrideid", startride.getStartRideId());
				return ViewConstants.CROSTARTRIDECONFORM;
			} else {
				model.addAttribute("startridefailed", 1);
				model.addAttribute("startrideerrormsg", "you have already started this ride");
				return ViewConstants.CROSTARTRIDECONFORM;
			}

		}

	}

	@RequestMapping(value = "/startridewithbooking")
	public String startridewithbooking(ModelMap model) {

		return ViewConstants.CROSTARTRIDEWITHBOOKINGPANEL;
	}

	@RequestMapping(value = "/addridewithbooking")
	public String startridewithbookingpage(ModelMap model, HttpServletRequest request) {
		StartRide startRide = new StartRide();
		model.addAttribute("startride", startRide);
		model.addAttribute("storeslist", bookingservice.getstores());
		model.addAttribute("cyclelist", startrideservice.getcycles());
		model.addAttribute("booking",
				bookingservice.getBookingbyid(Integer.parseInt(request.getParameter("bookingid"))));
		return ViewConstants.CROSTARTRIDEWITHBOOKINGPAGE;
	}

	@RequestMapping(value = "/doaddridewithbooking", method = RequestMethod.POST)
	public String Dostartride(ModelMap model, @Valid @ModelAttribute("startride") StartRide startRide,
			BindingResult theBindingResult) {
		if (theBindingResult.hasErrors()) {
			return ViewConstants.CROSTARTRIDEWITHBOOKINGPAGE;
		} else {
			startrideservice.addstartridewithbookingid(startRide);
			model.addAttribute("startride", startRide.getStartRideId());
			return ViewConstants.CROSTARTRIDECONFORM;
		}

	}

	@RequestMapping(value = "/endridepanel")
	public String EndRidePanel(ModelMap model, HttpServletRequest request) {

		return ViewConstants.CROENDRIDEPANEL;
	}

	@RequestMapping(value = "/endride")
	public String EndRidePage(ModelMap model, HttpServletRequest request) {
		EndRide endRide = new EndRide();
		model.addAttribute("endride", endRide);
		model.addAttribute("storeslist", bookingservice.getstores());
		model.addAttribute("statride",
				startrideservice.getStartRidebyid(Integer.parseInt(request.getParameter("startrideid"))));
		return ViewConstants.CROENDRIDEPAGE;
	}

	@RequestMapping(value = "/doendride", method = RequestMethod.POST)
	public String DoEndride(ModelMap model, @Valid @ModelAttribute("endride") EndRide endRide,
			BindingResult theBindingResult) {
		if (theBindingResult.hasErrors()) {
			return "EndRidePage";
		} else {
			endRide.setTotalTime(6);
			endrideservice.addendride(endRide);
			model.addAttribute("endrideid:", endRide.getEndRideId());
			return "EndRideConform";
		}

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		model.addAttribute("msg", "You've been logged outsuccessfully.");
		return "redirect:/login";
	}

	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "accessDenied";
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
