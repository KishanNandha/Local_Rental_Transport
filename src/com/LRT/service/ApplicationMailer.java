package com.LRT.service;
 
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
 
@Service("mailService")
public class ApplicationMailer
{
    @Autowired
    private MailSender mailSender;
     
    @Autowired
	private JavaMailSender mailHTMLSender;

	@Autowired
    private SimpleMailMessage preConfiguredMessage;
 
    /**
     * This method will send compose and send the message
     * */
    public void sendMail(String to, String subject, String body)
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }
 
	/**
	 * this method will send html mail
	 */
	public void sendHTMLMail(String to, String subject, String msg) {
		try {

			MimeMessage message = mailHTMLSender.createMimeMessage();
			String from = "localrentaltransport@gmail.com";
			message.setSubject(subject);
			MimeMessageHelper helper;
			helper = new MimeMessageHelper(message, true);
			helper.setFrom(from);
			helper.setTo(to);
			helper.setText(msg, true);
			mailHTMLSender.send(message);
		} catch (MessagingException ex) {
		}
	}

	/*
	 * public void sendPreConfiguredMail(String message, String to, int bookingid) {
	 * SimpleMailMessage mailMessage = new SimpleMailMessage(preConfiguredMessage);
	 * mailMessage.setText(message); mailSender.send(mailMessage); }
	 */
}