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
import com.LRT.model.Bookings;
import com.LRT.service.BookingService;


@Controller
@RequestMapping(value = "/user")
@Transactional
public class UserController {

	@Autowired
	private BookingService bookingservice;

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {


		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@RequestMapping(value = "/home")
	public String homePage(ModelMap model, HttpSession httpsession) {
		httpsession.setAttribute("sessionuser", getPrincipal());
		return ViewConstants.USERDASHBOARD;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpSession httpsession, ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		model.addAttribute("msg", "You've been logged outsuccessfully.");

		return "redirect:/login";
	}

	@RequestMapping(value = "/bookride")
	public String BookRide(ModelMap model) {
		Bookings booking = new Bookings();
		model.addAttribute("booking", booking);
		model.addAttribute("storeslist", bookingservice.getstores());
		return ViewConstants.USERBOOKRIDE;
	}


	@RequestMapping(value = "/dobooking", method = RequestMethod.POST)
	public String DoBooking(ModelMap model, @Valid @ModelAttribute("booking") Bookings booking,
			BindingResult theBindingResult) {
		booking.setUserName(getPrincipal());
		if (theBindingResult.hasErrors()) {
			return ViewConstants.USERBOOKRIDE;
		} else {
			if (bookingservice.chkBooking(booking)) {
				bookingservice.addbooking(booking);
				model.addAttribute("bookingfailed", 0);
				model.addAttribute("bookingid", booking.getBookingId());
				return ViewConstants.USERBOOKINGCONFORM;
			} else {
				model.addAttribute("bookingfailed", 1);
				model.addAttribute("bookingerrormsg", "you have already booked this ride");
				return ViewConstants.USERBOOKINGCONFORM;
			}
		}
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
