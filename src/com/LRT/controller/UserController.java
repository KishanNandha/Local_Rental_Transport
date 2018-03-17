package com.LRT.controller;

import java.util.List;

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
import com.LRT.service.ApplicationMailer;
import com.LRT.service.BookingService;


@Controller
@RequestMapping(value = "/user")
@Transactional
public class UserController {

	@Autowired
	private BookingService bookingservice;

	@Autowired
	private ApplicationMailer mailer;

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
				// get user details
				com.LRT.model.UserDetails userDetails = bookingservice.getDetailsofUser(getPrincipal());
				// create body of mail
				String body = "Save booking Id: \n" + booking.getBookingId();
				// Send a composed mail
				mailer.sendMail(userDetails.getEmail(), "LRT:Booking Details", body);
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

	@RequestMapping(value = "/viewbookings")
	public String ViewBookingPage(ModelMap model) {
		List<Bookings> list = bookingservice.getBookingsByUsername(getPrincipal());
		System.out.println(list.toString());
		model.addAttribute("bookinglist", list);
		model.addAttribute("bookingdeletedflag ", 0);
		return ViewConstants.USERVIEWBOOKING;
	}

	@RequestMapping(value = "/Access_Denied", method = RequestMethod.POST)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "accessDenied";
	}

	@RequestMapping(value = "/deletebooking", method = RequestMethod.GET)
	public String deleteBooking(ModelMap model, HttpServletRequest request) {
		Bookings booking = bookingservice
				.getBookingbyid(Integer.parseInt(request.getParameter("bookingid")));
		bookingservice.deletebooking(booking);
		model.addAttribute("bookingdeletedflag", 1);
		model.addAttribute("bookingdeletedmsg", "Deleted: " + booking.toString());
		List<Bookings> list = bookingservice.getBookingsByUsername(getPrincipal());
		model.addAttribute("bookinglist", list);
		return ViewConstants.USERVIEWBOOKING;
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
