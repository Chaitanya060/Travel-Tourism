package com.klef.jfsd.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	 @Autowired
	    private JavaMailSender mailSender;

	    public void sendOtp(String toEmail, String otp) {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(toEmail);
	        message.setSubject("Your OTP for Registration");
	        message.setText("Your OTP is: " + otp + "\n\nPlease use this to complete your registration.");
	        mailSender.send(message);
	    }

}
