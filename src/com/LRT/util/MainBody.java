package com.LRT.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.LRT.model.Bookings;
import com.LRT.model.EndRide;
import com.LRT.model.StartRide;


public class MainBody {
	private Bookings booking;
	private StartRide startRide;
	private EndRide endride;
	private String useremail;


	public MainBody(Bookings booking, String useremail) {
		super();
		this.booking = booking;
		this.useremail = useremail;
	}

	public MainBody(EndRide endride, StartRide startRide, String useremail) {
		super();
		this.startRide = startRide;
		this.endride = endride;
		this.useremail = useremail;
	}

	public MainBody(com.LRT.model.StartRide startRide, String useremail) {
		super();
		this.startRide = startRide;
		this.useremail = useremail;
	}


	public String getBookingBody() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String todaydate=dateFormat.format(date).toString();
		String body="<!doctype html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"    <meta charset=\"utf-8\">\r\n" + 
				"    <title>A simple, clean, and responsive HTML invoice template</title>\r\n" + 
				"    <style>\r\n" + 
				"body {\r\n" + 
				"    background-image: url(\"http://rowingsicilia.org/wp-content/uploads/2016/01/background.jpg\");\r\n" + 
				"    background-repeat: no-repeat;\r\n" + 
				"}\r\n" + 
				"</style>\r\n" + 
				"</style>\r\n" + 
				"    <style>\r\n" + 
				"    .invoice-box {\r\n" + 
				"        max-width: 800px;\r\n" + 
				"        margin: auto;\r\n" + 
				"        padding: 30px;\r\n" + 
				"        border: 1px solid #eee;\r\n" + 
				"        box-shadow: 0 0 10px rgba(0, 0, 0, .15);\r\n" + 
				"        font-size: 16px;\r\n" + 
				"        line-height: 24px;\r\n" + 
				"        font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif;\r\n" + 
				"        color: #555;\r\n" + 
				"    }\r\n" + 
				"    \r\n" + 
				"    .invoice-box table {\r\n" + 
				"        width: 100%;\r\n" + 
				"        line-height: inherit;\r\n" + 
				"        text-align: left;\r\n" + 
				"    }\r\n" + 
				"    \r\n" + 
				"    .invoice-box table td {\r\n" + 
				"        padding: 5px;\r\n" + 
				"        vertical-align: top;\r\n" + 
				"    }\r\n" + 
				"    \r\n" + 
				"    .invoice-box table tr td:nth-child(2) {\r\n" + 
				"        text-align: right;\r\n" + 
				"    }\r\n" + 
				"    \r\n" + 
				"    .invoice-box table tr.top table td {\r\n" + 
				"        padding-bottom: 20px;\r\n" + 
				"    }\r\n" + 
				"    \r\n" + 
				"    .invoice-box table tr.top table td.title {\r\n" + 
				"        font-size: 45px;\r\n" + 
				"        line-height: 45px;\r\n" + 
				"        color: #333;\r\n" + 
				"    }\r\n" + 
				"    \r\n" + 
				"    .invoice-box table tr.information table td {\r\n" + 
				"        padding-bottom: 40px;\r\n" + 
				"    }\r\n" + 
				"    \r\n" + 
				"    .invoice-box table tr.heading td {\r\n" + 
				"        background: #eee;\r\n" + 
				"        border-bottom: 1px solid #ddd;\r\n" + 
				"        font-weight: bold;\r\n" + 
				"    }\r\n" + 
				"    \r\n" + 
				"    .invoice-box table tr.details td {\r\n" + 
				"        padding-bottom: 20px;\r\n" + 
				"    }\r\n" + 
				"    \r\n" + 
				"    .invoice-box table tr.item td{\r\n" + 
				"        border-bottom: 1px solid #eee;\r\n" + 
				"    }\r\n" + 
				"    \r\n" + 
				"    .invoice-box table tr.item.last td {\r\n" + 
				"        border-bottom: none;\r\n" + 
				"    }\r\n" + 
				"    \r\n" + 
				"    .invoice-box table tr.total td:nth-child(2) {\r\n" + 
				"        border-top: 2px solid #eee;\r\n" + 
				"        font-weight: bold;\r\n" + 
				"    }\r\n" + 
				"    \r\n" + 
				"    @media only screen and (max-width: 600px) {\r\n" + 
				"        .invoice-box table tr.top table td {\r\n" + 
				"            width: 100%;\r\n" + 
				"            display: block;\r\n" + 
				"            text-align: center;\r\n" + 
				"        }\r\n" + 
				"        \r\n" + 
				"        .invoice-box table tr.information table td {\r\n" + 
				"            width: 100%;\r\n" + 
				"            display: block;\r\n" + 
				"            text-align: center;\r\n" + 
				"        }\r\n" + 
				"    }\r\n" + 
				"    \r\n" + 
				"    /** RTL **/\r\n" + 
				"    .rtl {\r\n" + 
				"        direction: rtl;\r\n" + 
				"        font-family: Tahoma, 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif;\r\n" + 
				"    }\r\n" + 
				"    \r\n" + 
				"    .rtl table {\r\n" + 
				"        text-align: right;\r\n" + 
				"    }\r\n" + 
				"    \r\n" + 
				"    .rtl table tr td:nth-child(2) {\r\n" + 
				"        text-align: left;\r\n" + 
				"    }\r\n" + 
				"    </style>\r\n" + 
				"</head>\r\n" + 
				"\r\n" + 
				"<body>\r\n" + 
				"    <div class=\"invoice-box\">\r\n" + 
				"        <table cellpadding=\"0\" cellspacing=\"0\">\r\n" + 
				"            <tr class=\"top\">\r\n" + 
				"                <td colspan=\"2\">\r\n" + 
				"                    <table>\r\n" + 
				"                        <tr>\r\n" + 
				"                            <td>\r\n" + 
				"                              <h1 style=\" margin-top:0px; width:100%; max-width:300px;\">Local Rental </h1>\r\n" + 
				"                              <h1 >Transport</h1>\r\n" + 
				"                            </td>\r\n" + 
				"                            \r\n" + 
				"                            <td>\r\n" + 
				"                               \r\n" + 
				"                                Created: " + todaydate + "<br>\r\n"
				+ 
				"                                Due:" + todaydate + "\r\n" + 
				"                            </td>\r\n" + 
				"                        </tr>\r\n" + 
				"                    </table>\r\n" + 
				"                </td>\r\n" + 
				"            </tr>\r\n" + 
				"            \r\n" + 
				"            <tr class=\"information\">\r\n" + 
				"                <td colspan=\"2\">\r\n" + 
				"                    <table>\r\n" + 
				"                        <tr>\r\n" + 
				"                            <td>\r\n" + 
				"                                LRT, Inc.<br>\r\n" + 
				"                                LJ Institute of Engineering & 		  Technology S.G. Highway,<br> Ahmedabad<br>\r\n" + 
				"                                \r\n" + 
				"                            </td>\r\n" + 
				"                            \r\n" + 
				"                            <td>\r\n" + 
				"                               " + booking.getUserName() + ".<br>\r\n"
				+ 
				"                                " + useremail + "\r\n" + 
				"                            </td>\r\n" + 
				"                        </tr>\r\n" + 
				"                    </table>\r\n" + 
				"                </td>\r\n" + 
				"            </tr>\r\n" + 
				"          \r\n" + 
				"            \r\n" + 
				"            <tr class=\"heading\">\r\n" + 
				"                <td >\r\n" + 
				"                   Booking Details\r\n" + 
				"                </td>\r\n" + 
				"                \r\n" + 
				"                <td>\r\n" + 
				"                    \r\n" + 
				"                </td>\r\n" + 
				"            </tr>\r\n" + 
				"            \r\n" + 
				"            <tr class=\"item\">\r\n" + 
				"                <td>\r\n" + 
				"                    Booking ID\r\n" + 
				"                </td>\r\n" + 
				"                \r\n" + 
				"                <td>\r\n" + 
				"                    " + booking.getBookingId() + "\r\n" + 
				"                </td>\r\n" + 
				"            </tr>\r\n" + 
				"            \r\n" + 
				"            <tr class=\"item\">\r\n" + 
				"                <td>\r\n" + 
				"                   Start Store\r\n" + 
				"                </td>\r\n" + 
				"                \r\n" + 
				"                <td>\r\n" + 
				"                   " + booking.getStartStoreName() + "\r\n" + 
				"                </td>\r\n" + 
				"            </tr>\r\n" + 
				"            \r\n" + 
				"            <tr class=\"item last\">\r\n" + 
				"                <td>\r\n" + 
				"                    Departure Date\r\n" + 
				"                </td>\r\n" + 
				"                \r\n" + 
				"                <td>\r\n" + 
				"                    " + booking.getDepartureDate() + "\r\n" + 
				"                </td>\r\n" + 
				"            </tr>\r\n" + 
				"            \r\n" + 
				"            <tr class=\"item last\">\r\n" + 
				"                <td>\r\n" + 
				"                    Departure Time\r\n" + 
				"                </td>\r\n" + 
				"                \r\n" + 
				"                <td>\r\n" + 
				"                    " + booking.getDepartureTime() + "\r\n" + 
				"                </td>\r\n" + 
				"            </tr>\r\n" + 
				"            \r\n" + 
				"             <tr class=\"item last\">\r\n" + 
				"                <td>\r\n" + 
				"                    Estimated End Time\r\n" + 
				"                </td>\r\n" + 
				"                \r\n" + 
				"                <td>\r\n" + 
				"                    " + booking.getEstimatedEndTime() + "\r\n" + 
				"                </td>\r\n" + 
				"            </tr>\r\n" + 
				"            \r\n" + 
				"            \r\n" + 
				"        </table>\r\n" + 
				"    </div>\r\n" + 
				"</body>\r\n" + 
				"</html>";
		
		return body;
	}
	
	public String getStartRideBody() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String todaydate=dateFormat.format(date).toString();
		String body="<!doctype html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"    <meta charset=\"utf-8\">\r\n" + 
				"    <title>A simple, clean, and responsive HTML invoice template</title>\r\n" + 
				"    <style>\r\n" + 
				"body {\r\n" + 
				"    background-image: url(\"http://rowingsicilia.org/wp-content/uploads/2016/01/background.jpg\");\r\n" + 
				"    background-repeat: no-repeat;\r\n" + 
				"}\r\n" + 
				"</style>\r\n" + 
				"</style>\r\n" + 
				"    <style>\r\n" + 
				"    .invoice-box {\r\n" + 
				"        max-width: 800px;\r\n" + 
				"        margin: auto;\r\n" + 
				"        padding: 30px;\r\n" + 
				"        border: 1px solid #eee;\r\n" + 
				"        box-shadow: 0 0 10px rgba(0, 0, 0, .15);\r\n" + 
				"        font-size: 16px;\r\n" + 
				"        line-height: 24px;\r\n" + 
				"        font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif;\r\n" + 
				"        color: #555;\r\n" + 
				"    }\r\n" + 
				"    \r\n" + 
				"    .invoice-box table {\r\n" + 
				"        width: 100%;\r\n" + 
				"        line-height: inherit;\r\n" + 
				"        text-align: left;\r\n" + 
				"    }\r\n" + 
				"    \r\n" + 
				"    .invoice-box table td {\r\n" + 
				"        padding: 5px;\r\n" + 
				"        vertical-align: top;\r\n" + 
				"    }\r\n" + 
				"    \r\n" + 
				"    .invoice-box table tr td:nth-child(2) {\r\n" + 
				"        text-align: right;\r\n" + 
				"    }\r\n" + 
				"    \r\n" + 
				"    .invoice-box table tr.top table td {\r\n" + 
				"        padding-bottom: 20px;\r\n" + 
				"    }\r\n" + 
				"    \r\n" + 
				"    .invoice-box table tr.top table td.title {\r\n" + 
				"        font-size: 45px;\r\n" + 
				"        line-height: 45px;\r\n" + 
				"        color: #333;\r\n" + 
				"    }\r\n" + 
				"    \r\n" + 
				"    .invoice-box table tr.information table td {\r\n" + 
				"        padding-bottom: 40px;\r\n" + 
				"    }\r\n" + 
				"    \r\n" + 
				"    .invoice-box table tr.heading td {\r\n" + 
				"        background: #eee;\r\n" + 
				"        border-bottom: 1px solid #ddd;\r\n" + 
				"        font-weight: bold;\r\n" + 
				"    }\r\n" + 
				"    \r\n" + 
				"    .invoice-box table tr.details td {\r\n" + 
				"        padding-bottom: 20px;\r\n" + 
				"    }\r\n" + 
				"    \r\n" + 
				"    .invoice-box table tr.item td{\r\n" + 
				"        border-bottom: 1px solid #eee;\r\n" + 
				"    }\r\n" + 
				"    \r\n" + 
				"    .invoice-box table tr.item.last td {\r\n" + 
				"        border-bottom: none;\r\n" + 
				"    }\r\n" + 
				"    \r\n" + 
				"    .invoice-box table tr.total td:nth-child(2) {\r\n" + 
				"        border-top: 2px solid #eee;\r\n" + 
				"        font-weight: bold;\r\n" + 
				"    }\r\n" + 
				"    \r\n" + 
				"    @media only screen and (max-width: 600px) {\r\n" + 
				"        .invoice-box table tr.top table td {\r\n" + 
				"            width: 100%;\r\n" + 
				"            display: block;\r\n" + 
				"            text-align: center;\r\n" + 
				"        }\r\n" + 
				"        \r\n" + 
				"        .invoice-box table tr.information table td {\r\n" + 
				"            width: 100%;\r\n" + 
				"            display: block;\r\n" + 
				"            text-align: center;\r\n" + 
				"        }\r\n" + 
				"    }\r\n" + 
				"    \r\n" + 
				"    /** RTL **/\r\n" + 
				"    .rtl {\r\n" + 
				"        direction: rtl;\r\n" + 
				"        font-family: Tahoma, 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif;\r\n" + 
				"    }\r\n" + 
				"    \r\n" + 
				"    .rtl table {\r\n" + 
				"        text-align: right;\r\n" + 
				"    }\r\n" + 
				"    \r\n" + 
				"    .rtl table tr td:nth-child(2) {\r\n" + 
				"        text-align: left;\r\n" + 
				"    }\r\n" + 
				"    </style>\r\n" + 
				"</head>\r\n" + 
				"\r\n" + 
				"<body>\r\n" + 
				"    <div class=\"invoice-box\">\r\n" + 
				"        <table cellpadding=\"0\" cellspacing=\"0\">\r\n" + 
				"            <tr class=\"top\">\r\n" + 
				"                <td colspan=\"2\">\r\n" + 
				"                    <table>\r\n" + 
				"                        <tr>\r\n" + 
				"                            <td>\r\n" + 
				"                              <h1 style=\" margin-top:0px; width:100%; max-width:300px;\">Local Rental </h1>\r\n" + 
				"                              <h1 >Transport</h1>\r\n" + 
				"                            </td>\r\n" + 
				"                            \r\n" + 
				"                            <td>\r\n" + 
				"                               \r\n" + 
				"                                Created: " + todaydate + "<br>\r\n"
				+ 
				"                                Due:" + todaydate + "\r\n" + 
				"                            </td>\r\n" + 
				"                        </tr>\r\n" + 
				"                    </table>\r\n" + 
				"                </td>\r\n" + 
				"            </tr>\r\n" + 
				"            \r\n" + 
				"            <tr class=\"information\">\r\n" + 
				"                <td colspan=\"2\">\r\n" + 
				"                    <table>\r\n" + 
				"                        <tr>\r\n" + 
				"                            <td>\r\n" + 
				"                                LRT, Inc.<br>\r\n" + 
				"                                LJ Institute of Engineering & 		  Technology S.G. Highway,<br> Ahmedabad<br>\r\n" + 
				"                                \r\n" + 
				"                            </td>\r\n" + 
				"                            \r\n" + 
				"                            <td>\r\n" + 
				"                               " + startRide.getUserName() + ".<br>\r\n"
				+ 
				"                                " + useremail + "\r\n" + 
				"                            </td>\r\n" + 
				"                        </tr>\r\n" + 
				"                    </table>\r\n" + 
				"                </td>\r\n" + 
				"            </tr>\r\n" + 
				"          \r\n" + 
				"            \r\n" + 
				"            <tr class=\"heading\">\r\n" + 
				"                <td >\r\n" + 
				"                   Booking Details\r\n" + 
				"                </td>\r\n" + 
				"                \r\n" + 
				"                <td>\r\n" + 
				"                    \r\n" + 
				"                </td>\r\n" + 
				"            </tr>\r\n" + 
				"            \r\n" + 
				"            <tr class=\"item\">\r\n" + 
				"                <td>\r\n" + 
				"                    Booking ID\r\n" + 
				"                </td>\r\n" + 
				"                \r\n" + 
				"                <td>\r\n" + 
				"                    " + startRide.getStartRideId() + "\r\n" + 
				"                </td>\r\n" + 
				"            </tr>\r\n" + 
				"            \r\n" + 
				"            <tr class=\"item\">\r\n" + 
				"                <td>\r\n" + 
				"                   Start Store\r\n" + 
				"                </td>\r\n" + 
				"                \r\n" + 
				"                <td>\r\n" + 
				"                   " + startRide.getStartStoreName() + "\r\n" + 
				"                </td>\r\n" + 
				"            </tr>\r\n" + 
				"            \r\n" + 
				"            <tr class=\"item last\">\r\n" + 
				"                <td>\r\n" + 
				"                    Departure Date\r\n" + 
				"                </td>\r\n" + 
				"                \r\n" + 
				"                <td>\r\n" + 
				"                    " + startRide.getDepartureDate() + "\r\n" + 
				"                </td>\r\n" + 
				"            </tr>\r\n" + 
				"            \r\n" + 
				"            <tr class=\"item last\">\r\n" + 
				"                <td>\r\n" + 
				"                    Departure Time\r\n" + 
				"                </td>\r\n" + 
				"                \r\n" + 
				"                <td>\r\n" + 
				"                    " + startRide.getDepartureTime() + "\r\n" + 
				"                </td>\r\n" + 
				"            </tr>\r\n" + 
				"            \r\n" + 
				"             <tr class=\"item last\">\r\n" + 
				"                <td>\r\n" + 
				"                    Estimated End Time\r\n" + 
				"                </td>\r\n" + 
				"                \r\n" + 
				"                <td>\r\n" + 
				"                    " + startRide.getEstimatedEndTime() + "\r\n" + 
				"                </td>\r\n" + 
				"            </tr>\r\n" + 
				"            \r\n" + 
				 "<tr class=\"item last\">\r\n" + 
							"                <td>\r\n" + 
				"                    Cycle ID\r\n" +
							"                </td>\r\n" + 
							"                \r\n" + 
							"                <td>\r\n" + 
				"                    " + startRide.getCycleId() + "\r\n" + 
							"                </td>\r\n" + 
							"            </tr>\r\n" + 
							"            \r\n" + 
				"            \r\n" + 
				"        </table>\r\n" + 
				"    </div>\r\n" + 
				"</body>\r\n" + 
				"</html>";
		
		return body;
	}
	public String getEndRideBody() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String todaydate=dateFormat.format(date).toString();
		String body="<!doctype html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"    <meta charset=\"utf-8\">\r\n" + 
				"    <title>A simple, clean, and responsive HTML invoice template</title>\r\n" + 
				"    <style>\r\n" + 
				"body {\r\n" + 
				"    background-image: url(\"http://rowingsicilia.org/wp-content/uploads/2016/01/background.jpg\");\r\n" + 
				"    background-repeat: no-repeat;\r\n" + 
				"}\r\n" + 
				"</style>\r\n" + 
				"</style>\r\n" + 
				"    <style>\r\n" + 
				"    .invoice-box {\r\n" + 
				"        max-width: 800px;\r\n" + 
				"        margin: auto;\r\n" + 
				"        padding: 30px;\r\n" + 
				"        border: 1px solid #eee;\r\n" + 
				"        box-shadow: 0 0 10px rgba(0, 0, 0, .15);\r\n" + 
				"        font-size: 16px;\r\n" + 
				"        line-height: 24px;\r\n" + 
				"        font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif;\r\n" + 
				"        color: #555;\r\n" + 
				"    }\r\n" + 
				"    \r\n" + 
				"    .invoice-box table {\r\n" + 
				"        width: 100%;\r\n" + 
				"        line-height: inherit;\r\n" + 
				"        text-align: left;\r\n" + 
				"    }\r\n" + 
				"    \r\n" + 
				"    .invoice-box table td {\r\n" + 
				"        padding: 5px;\r\n" + 
				"        vertical-align: top;\r\n" + 
				"    }\r\n" + 
				"    \r\n" + 
				"    .invoice-box table tr td:nth-child(2) {\r\n" + 
				"        text-align: right;\r\n" + 
				"    }\r\n" + 
				"    \r\n" + 
				"    .invoice-box table tr.top table td {\r\n" + 
				"        padding-bottom: 20px;\r\n" + 
				"    }\r\n" + 
				"    \r\n" + 
				"    .invoice-box table tr.top table td.title {\r\n" + 
				"        font-size: 45px;\r\n" + 
				"        line-height: 45px;\r\n" + 
				"        color: #333;\r\n" + 
				"    }\r\n" + 
				"    \r\n" + 
				"    .invoice-box table tr.information table td {\r\n" + 
				"        padding-bottom: 40px;\r\n" + 
				"    }\r\n" + 
				"    \r\n" + 
				"    .invoice-box table tr.heading td {\r\n" + 
				"        background: #eee;\r\n" + 
				"        border-bottom: 1px solid #ddd;\r\n" + 
				"        font-weight: bold;\r\n" + 
				"    }\r\n" + 
				"    \r\n" + 
				"    .invoice-box table tr.details td {\r\n" + 
				"        padding-bottom: 20px;\r\n" + 
				"    }\r\n" + 
				"    \r\n" + 
				"    .invoice-box table tr.item td{\r\n" + 
				"        border-bottom: 1px solid #eee;\r\n" + 
				"    }\r\n" + 
				"    \r\n" + 
				"    .invoice-box table tr.item.last td {\r\n" + 
				"        border-bottom: none;\r\n" + 
				"    }\r\n" + 
				"    \r\n" + 
				"    .invoice-box table tr.total td:nth-child(2) {\r\n" + 
				"        border-top: 2px solid #eee;\r\n" + 
				"        font-weight: bold;\r\n" + 
				"    }\r\n" + 
				"    \r\n" + 
				"    @media only screen and (max-width: 600px) {\r\n" + 
				"        .invoice-box table tr.top table td {\r\n" + 
				"            width: 100%;\r\n" + 
				"            display: block;\r\n" + 
				"            text-align: center;\r\n" + 
				"        }\r\n" + 
				"        \r\n" + 
				"        .invoice-box table tr.information table td {\r\n" + 
				"            width: 100%;\r\n" + 
				"            display: block;\r\n" + 
				"            text-align: center;\r\n" + 
				"        }\r\n" + 
				"    }\r\n" + 
				"    \r\n" + 
				"    /** RTL **/\r\n" + 
				"    .rtl {\r\n" + 
				"        direction: rtl;\r\n" + 
				"        font-family: Tahoma, 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif;\r\n" + 
				"    }\r\n" + 
				"    \r\n" + 
				"    .rtl table {\r\n" + 
				"        text-align: right;\r\n" + 
				"    }\r\n" + 
				"    \r\n" + 
				"    .rtl table tr td:nth-child(2) {\r\n" + 
				"        text-align: left;\r\n" + 
				"    }\r\n" + 
				"    </style>\r\n" + 
				"</head>\r\n" + 
				"\r\n" + 
				"<body>\r\n" + 
				"    <div class=\"invoice-box\">\r\n" + 
				"        <table cellpadding=\"0\" cellspacing=\"0\">\r\n" + 
				"            <tr class=\"top\">\r\n" + 
				"                <td colspan=\"2\">\r\n" + 
				"                    <table>\r\n" + 
				"                        <tr>\r\n" + 
				"                            <td>\r\n" + 
				"                              <h1 style=\" margin-top:0px; width:100%; max-width:300px;\">Local Rental </h1>\r\n" + 
				"                              <h1 >Transport</h1>\r\n" + 
				"                            </td>\r\n" + 
				"                            \r\n" + 
				"                            <td>\r\n" + 
				"                               \r\n" + 
				"                                Created: " + todaydate + "<br>\r\n"
				+ 
				"                                Due:" + todaydate + "\r\n" + 
				"                            </td>\r\n" + 
				"                        </tr>\r\n" + 
				"                    </table>\r\n" + 
				"                </td>\r\n" + 
				"            </tr>\r\n" + 
				"            \r\n" + 
				"            <tr class=\"information\">\r\n" + 
				"                <td colspan=\"2\">\r\n" + 
				"                    <table>\r\n" + 
				"                        <tr>\r\n" + 
				"                            <td>\r\n" + 
				"                                LRT, Inc.<br>\r\n" + 
				"                                LJ Institute of Engineering & 		  Technology S.G. Highway,<br> Ahmedabad<br>\r\n" + 
				"                                \r\n" + 
				"                            </td>\r\n" + 
				"                            \r\n" + 
				"                            <td>\r\n" + 
				"                               " + startRide.getUserName() + ".<br>\r\n"
				+ 
				"                                " + useremail + "\r\n" + 
				"                            </td>\r\n" + 
				"                        </tr>\r\n" + 
				"                    </table>\r\n" + 
				"                </td>\r\n" + 
				"            </tr>\r\n" + 
				"          \r\n" + 
				"            \r\n" + 
				"            <tr class=\"heading\">\r\n" + 
				"                <td >\r\n" + 
				"                   Booking Details\r\n" + 
				"                </td>\r\n" + 
				"                \r\n" + 
				"                <td>\r\n" + 
				"                    \r\n" + 
				"                </td>\r\n" + 
				"            </tr>\r\n" + 
				"            \r\n" + 
				"            <tr class=\"item\">\r\n" + 
				"                <td>\r\n" + 
				"                    Booking ID\r\n" + 
				"                </td>\r\n" + 
				"                \r\n" + 
				"                <td>\r\n" + 
				"                    " + startRide.getStartRideId() + "\r\n" + 
				"                </td>\r\n" + 
				"            </tr>\r\n" + 
				"            \r\n" + 
				"            <tr class=\"item\">\r\n" + 
				"                <td>\r\n" + 
				"                   Start Store\r\n" + 
				"                </td>\r\n" + 
				"                \r\n" + 
				"                <td>\r\n" + 
				"                   " + startRide.getStartStoreName() + "\r\n" + 
				"                </td>\r\n" + 
				"            </tr>\r\n" + 
				"            \r\n" + 
				"            <tr class=\"item last\">\r\n" + 
				"                <td>\r\n" + 
				"                    Departure Date\r\n" + 
				"                </td>\r\n" + 
				"                \r\n" + 
				"                <td>\r\n" + 
				"                    " + startRide.getDepartureDate() + "\r\n" + 
				"                </td>\r\n" + 
				"            </tr>\r\n" + 
				"            \r\n" + 
				"            <tr class=\"item last\">\r\n" + 
				"                <td>\r\n" + 
				"                    Departure Time\r\n" + 
				"                </td>\r\n" + 
				"                \r\n" + 
				"                <td>\r\n" + 
				"                    " + startRide.getDepartureTime() + "\r\n" + 
				"                </td>\r\n" + 
				"            </tr>\r\n" + 
				"            \r\n" + 
				"             <tr class=\"item last\">\r\n" + 
				"                <td>\r\n" + 
				"                    Estimated End Time\r\n" + 
				"                </td>\r\n" + 
				"                \r\n" + 
				"                <td>\r\n" + 
				"                    " + startRide.getEstimatedEndTime() + "\r\n" + 
				"                </td>\r\n" + 
				"            </tr>\r\n" + 
				"            \r\n" + 
				 "<tr class=\"item last\">\r\n" + 
							"                <td>\r\n" + 
				"                    Cycle ID\r\n" +
							"                </td>\r\n" + 
							"                \r\n" + 
							"                <td>\r\n" + 
				"                    " + startRide.getCycleId() + "\r\n" + 
							"                </td>\r\n" + 
							"            </tr>\r\n" + 
							"            \r\n" + 
							"<tr class=\"item last\">\r\n" + 
							"                <td>\r\n" + 
				"                    End Ride ID\r\n" +
							"                </td>\r\n" + 
							"                \r\n" + 
							"                <td>\r\n" + 
				"                    " + endride.getEndRideId() + "\r\n" + 
							"                </td>\r\n" + 
							"            </tr>\r\n" + 
							"            \r\n" + 
							"<tr class=\"item last\">\r\n" + 
							"                <td>\r\n" + 
				"                    End Time\r\n" +
							"                </td>\r\n" + 
							"                \r\n" + 
							"                <td>\r\n" + 
				"                    " + endride.getEndTime() + "\r\n" + 
							"                </td>\r\n" + 
							"            </tr>\r\n" + 
							"            \r\n" + 
							"<tr class=\"item last\">\r\n" + 
							"                <td>\r\n" + 
				"                    End Store\r\n" +
							"                </td>\r\n" + 
							"                \r\n" + 
							"                <td>\r\n" + 
				"                    " + endride.getEndStoreName() + "\r\n" + 
							"                </td>\r\n" + 
							"            </tr>\r\n" + 
							"            \r\n" + 
							"<tr class=\"item last\">\r\n" + 
							"                <td>\r\n" + 
				"                    Total Time\r\n" +
							"                </td>\r\n" + 
							"                \r\n" + 
							"                <td>\r\n" + 
				"                    " + endride.getTotalTime() + "\r\n" + 
							"                </td>\r\n" + 
							"            </tr>\r\n" + 
							"            \r\n" + 
							"<tr class=\"item last\">\r\n" + 
							"                <td>\r\n" + 
				"                    Total Amount\r\n" +
							"                </td>\r\n" + 
							"                \r\n" + 
							"                <td>\r\n" + 
				"                    " + endride.getTotalAmount() + "\r\n" + 
							"                </td>\r\n" + 
							"            </tr>\r\n" + 
							"            \r\n" + 
				"            \r\n" + 
				"        </table>\r\n" + 
				"    </div>\r\n" + 
				"</body>\r\n" + 
				"</html>";
		
		return body;
	}
}
