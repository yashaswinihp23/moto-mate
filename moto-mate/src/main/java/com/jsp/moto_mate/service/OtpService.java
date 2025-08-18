package com.jsp.moto_mate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
//import com.twilio.rest.api.v2010.account.Message;
//import com.twilio.type.PhoneNumber;
import com.twilio.type.PhoneNumber;

import jakarta.mail.internet.MimeMessage;

@Service
public class OtpService {

    @Autowired
    private JavaMailSender mailSender;
    
    @Autowired
    TemplateEngine engine;
    
    @Value("${spring.mail.username}")
    String fromEmail;
    
    // Twilio credentials from application.properties
    @Value("${twilio.account-sid}")
    private String accountSid;

    @Value("${twilio.auth-token}")
    private String authToken;

    @Value("${twilio.phone-number}")
    private String twilioNumber;

    
    public void sendEmailOtp(String email, int otp) {
        System.out.println("Sending OTP: " + otp + " to Email: " + email);
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);

            helper.setTo(email);
            helper.setSubject("MotoMate OTP Verification");
            helper.setFrom(fromEmail,"MotoMate");

            Context context=new Context();
            context.setVariable("otp",otp);
            context.setVariable("email",email);
            
            
			String body = engine.process("otp-form.html",context);
            
			helper.setText(body,true);
			
            mailSender.send(message);
            System.out.println("✅ OTP email sent successfully to " + email);

        } catch (Exception e) {
            System.out.println("❌ Failed to send OTP email to " + email);
            e.printStackTrace();
        }
    }

    public void sendMobileOtp(long mobile, int otp) {
        // Placeholder for SMS logic (if any)
    	 System.out.println("Sending OTP: " + otp + " to Mobile: " + mobile);
         try {
             Twilio.init(accountSid, authToken);

             Message.creator(
                 new PhoneNumber("+91" + mobile),  // Receiver's number
                 new PhoneNumber(twilioNumber),    // Your Twilio number
                 "Your OTP for MotoMate is: " + otp
             ).create();

             System.out.println("✅ OTP SMS sent successfully to +91" + mobile);

         } catch (Exception e) {
             System.out.println("❌ Failed to send OTP SMS to +91" + mobile);
             e.printStackTrace();
         }
     }
 }









