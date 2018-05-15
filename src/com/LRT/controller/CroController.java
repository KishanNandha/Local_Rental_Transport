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
import com.LRT.service.ApplicationMailer;
import com.LRT.service.BookingService;
import com.LRT.service.EtartRideService;
import com.LRT.service.StartRideService;
import com.LRT.util.MainBody;

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

	private MainBody mainbody;

	@Autowired
	private com.LRT.service.UserDetailsSevice userdetailsservice;

	@Autowired
	private ApplicationMailer mailer;

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
		httpSession.setAttribute("hourlyRate", endrideservice.getHourlyRate());
	}

	@RequestMapping(value = "/home")
	public String homePage(ModelMap model, HttpSession httpsession) {
		commonService();
		return ViewConstants.CRODASHBOARD;
	}

	@RequestMapping(value = "/startridewithoutbooking")
	public String startRidewithoutbooking(ModelMap model) {
		commonService();
		StartRide startRide = new StartRide();
		model.addAttribute("startride", startRide);
		model.addAttribute("storeslist", bookingservice.getstores());
		model.addAttribute("cyclelist", startrideservice.getcycles());
		return ViewConstants.CROSTARTRIDEWITHOUTBOOKINGPAGE;
	}

	@RequestMapping(value = "/doaddridewithoutbooking", method = RequestMethod.POST)
	public String Dostart(ModelMap model, @Valid @ModelAttribute("startride") StartRide startride,
			BindingResult theBindingResult) {
		commonService();
		if (theBindingResult.hasErrors()) {
			return ViewConstants.CROSTARTRIDEWITHOUTBOOKINGPAGE;
		} else {
			if (startrideservice.chkStartRide(startride)) {
				startrideservice.addstartride(startride);
				com.LRT.model.UserDetails userDetails = bookingservice.getDetailsofUser(getPrincipal());
				// create body of mail
				mainbody = new MainBody(startride, userDetails.getEmail());
				String body = mainbody.getStartRideBody();
				// Send a composed mail
				/* mailer.sendMail(userDetails.getEmail(), "LRT:Booking Details", body); */
				mailer.sendHTMLMail(userDetails.getEmail(), "LRT:Start Ride Details", body);
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
		commonService();
		model.addAttribute("nobookingfound", 0);
		return ViewConstants.CROSTARTRIDEWITHBOOKINGPANEL;
	}

	@RequestMapping(value = "/addridewithbooking")
	public String startridewithbookingpage(ModelMap model, HttpServletRequest request) {
		commonService();
		if (bookingservice.getBookingbyid(Integer.parseInt(request.getParameter("bookingid"))) != null)
		{

			StartRide startRide = new StartRide();
			model.addAttribute("startride", startRide);
			model.addAttribute("storeslist", bookingservice.getstores());
			model.addAttribute("cyclelist", startrideservice.getcycles());
			model.addAttribute("booking",
					bookingservice.getBookingbyid(Integer.parseInt(request.getParameter("bookingid"))));

			return ViewConstants.CROSTARTRIDEWITHBOOKINGPAGE;

		} else {
			model.addAttribute("nobookingfound", 1);
			model.addAttribute("msg", "no booking found ...try other booking id");
			return ViewConstants.CROSTARTRIDEWITHBOOKINGPANEL;
		}

	}

	@RequestMapping(value = "/doaddridewithbooking", method = RequestMethod.POST)
	public String Dostartride(ModelMap model, @Valid @ModelAttribute("startride") StartRide startride,
			BindingResult theBindingResult, HttpServletRequest request) {
		commonService();
		if (theBindingResult.hasErrors()) {
			return ViewConstants.CROSTARTRIDEWITHBOOKINGPAGE;
		} else {
			if (startrideservice.chkStartRide(startride)) {

				startrideservice.addstartridewithbookingid(Integer.parseInt(request.getParameter("bookingid")),
						startride);
				com.LRT.model.UserDetails userDetails = bookingservice.getDetailsofUser(startride.getUserName());
				// create body of mail
				mainbody = new MainBody(startride, userDetails.getEmail());
				String body = mainbody.getStartRideBody();
				// Send a composed mail
				/* mailer.sendMail(userDetails.getEmail(), "LRT:Booking Details", body); */
				mailer.sendHTMLMail(userDetails.getEmail(), "LRT:Start Ride Details", body);
				model.addAttribute("startridefailed1", 0);
				model.addAttribute("startrideid", startride.getStartRideId());
				return ViewConstants.CROSTARTRIDECONFORM;

			}
			else {
				model.addAttribute("startridefailed1", 1);
				model.addAttribute("startrideerrormsg", "you have already started this ride");
				return ViewConstants.CROSTARTRIDECONFORM;
			}

		}

	}

	@RequestMapping(value = "/endridepanel")
	public String EndRidePanel(ModelMap model, HttpServletRequest request) {

		return ViewConstants.CROENDRIDEPANEL;
	}

	@RequestMapping(value = "/endride")
	public String EndRidePage(ModelMap model, HttpServletRequest request) {
		commonService();
		EndRide endRide = new EndRide();
		model.addAttribute("endride", endRide);
		model.addAttribute("storeslist", bookingservice.getstores());
		model.addAttribute("statride",
				startrideservice.getStartRidebyid(Integer.parseInt(request.getParameter("startrideid"))));
		return ViewConstants.CROENDRIDEPAGE;
	}

	@RequestMapping(value = "/doendride", method = RequestMethod.POST)
	public String DoEndride(HttpSession httpsession, ModelMap model, @Valid @ModelAttribute("endride") EndRide endRide,
			BindingResult theBindingResult) {
		commonService();
		if (theBindingResult.hasErrors()) {
			return ViewConstants.CROENDRIDEPANEL;
		} else {
			if (endrideservice.chkEndRide(endRide)) {
				StartRide startRide =startrideservice.getStartRidebyid(endRide.getStartRideId());
				endRide = endrideservice.calAmount(endRide, startRide);
				com.LRT.model.UserDetails clientDetails = bookingservice.getDetailsofUser(startRide.getUserName());
				httpsession.setAttribute("clientBean", clientDetails);

				endrideservice.addendride(endRide, startRide);

				com.LRT.model.UserDetails userDetails = bookingservice.getDetailsofUser(startRide.getUserName());
				// create body of mail
				mainbody = new MainBody(endRide, startRide,
						userDetails.getEmail());
				String body = mainbody.getEndRideBody();
				// Send a composed mail
				/* mailer.sendMail(userDetails.getEmail(), "LRT:Booking Details", body); */
				mailer.sendHTMLMail(userDetails.getEmail(), "LRT:End Ride Details", body);
				model.addAttribute("StartRideid:", endRide.getEndRideId());
				model.addAttribute("endridefailed", 0);
				model.addAttribute("StartStore", startRide.getStartStoreName());
				model.addAttribute("DepartureDate", startRide.getDepartureDate());
				model.addAttribute("DepartureTime", startRide.getDepartureTime());
				model.addAttribute("EndTime", endRide.getEndTime());
				model.addAttribute("EndStore", endRide.getEndStoreName());
				model.addAttribute("TotalTime", endRide.getTotalTime());
				model.addAttribute("TotalAmount", endRide.getTotalAmount());
				return ViewConstants.CROENDRIDECONFORM;
			} else {
				model.addAttribute("endridefailed", 1);
				return ViewConstants.CROENDRIDECONFORM;
			}

		}

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		commonService();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		model.addAttribute("msg", "You've been logged outsuccessfully.");
		return "redirect:/login";
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

	@RequestMapping(value = "/viewallendride", method = RequestMethod.GET)
	public String ViewAllEndRide(ModelMap model) {
		commonService();
		model.addAttribute("endridelist", endrideservice.ListEndRide());
		return ViewConstants.CROVIEWALLENDRIDE;
	}

	@RequestMapping(value = "/viewallstartride", method = RequestMethod.GET)
	public String ViewAllStartRide(ModelMap model) {
		commonService();
		model.addAttribute("storeslist", bookingservice.getstores());
		return ViewConstants.CROVIEWALLSTARTRIDE;
	}

	@RequestMapping(value = "/deletestartride", method = RequestMethod.GET)
	public String deleteStartRide(ModelMap model, HttpServletRequest request) {
		commonService();
		startrideservice.removeStartRide(Integer.parseInt(request.getParameter("startrideid")));
		model.addAttribute("startridedeletedflag", 1);
		return ViewConstants.CROVIEWALLSTARTRIDE;
	}
	
	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		commonService();
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

	@RequestMapping(value = "/makepayment")
	public String makepayment(ModelMap model) {
		return "pgRedirect";
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
			@Valid @ModelAttribute("userdata") com.LRT.model.UserDetails userdata,
			BindingResult theBindingResult) {
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

	@RequestMapping(value = "/editprofilePage", method = RequestMethod.GET)
	public String editProfile(ModelMap model) {
		return ViewConstants.EDITPROFILE;
	}

	@RequestMapping(value = "/editprofile", method = RequestMethod.POST)
	public String doeditProfile(ModelMap model) {
		return ViewConstants.EDITPROFILE;
	}

}
