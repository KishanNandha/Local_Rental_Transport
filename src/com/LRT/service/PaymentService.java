package com.LRT.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Details;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

@Service
public class PaymentService {


	private final String clientId = "";
	private final String clientSecret = "";
	private final String mode = "sandbox";

	public Payment proecssPayment(HttpServletRequest request) {

		APIContext apiContext = new APIContext(clientId, clientSecret, mode);
		// Set payer details
		Payer payer = new Payer();
		payer.setPaymentMethod("paypal");

		/*
		 * // Set redirect URLs RedirectUrls redirectUrls = new RedirectUrls();
		 * redirectUrls.setCancelUrl(
		 * "http://localhost:8080/paypalrestintegration/cancel");
		 * redirectUrls.setReturnUrl(
		 * "http://localhost:8080/paypalrestintegration/PaypalDirectPayment");
		 */

		// Set payment details
		double shipping = Double.parseDouble(request.getParameter("shipping"));
		double cartTotal = Double.parseDouble(request.getParameter("cartTotal"));
		double tax = (cartTotal * 14) / 100;

		Details details = new Details();
		details.setShipping(shipping + "");
		details.setSubtotal(cartTotal + "");
		details.setTax(tax + "");

		double total = cartTotal + shipping + tax;

		// Payment amount
		Amount amount = new Amount();
		amount.setCurrency("USD");
		// Total must be equal to sum of shipping, tax and subtotal.
		amount.setTotal("" + total);
		amount.setDetails(details);

		// Transaction information
		Transaction transaction = new Transaction();
		transaction.setAmount(amount);
		transaction.setDescription("This is the payment transaction description.");

		// Add transaction to a list
		List<Transaction> transactions = new ArrayList<Transaction>();
		transactions.add(transaction);

		// Add payment details
		Payment payment = new Payment();
		payment.setIntent("sale");
		payment.setPayer(payer);
		payment.setTransactions(transactions);

		// Create payment

		Payment createdPayment = null;
		try {
			createdPayment = payment.create(apiContext);
		} catch (PayPalRESTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return createdPayment;
	}

	public Payment completePayment(String paymentid, String payerid) {
		APIContext apiContext = new APIContext(clientId, clientSecret, mode);
		Payment payment = new Payment();
		payment.setId(paymentid);

		PaymentExecution paymentExecution = new PaymentExecution();
		paymentExecution.setPayerId(paymentid);

		Payment createdPayment = null;
		try {
			createdPayment = payment.execute(apiContext, paymentExecution);
		} catch (PayPalRESTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return createdPayment;
	}
}
