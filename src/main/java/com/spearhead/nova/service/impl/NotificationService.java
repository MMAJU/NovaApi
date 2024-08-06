package com.spearhead.nova.service.impl;

import java.util.Map;

import javax.mail.MessagingException;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.IExpressionContext;
import org.thymeleaf.linkbuilder.ILinkBuilder;

import com.spearhead.nova.model.User;


@Service
public class NotificationService {

	private JavaMailSender javaMailSender;

	private TemplateEngine templateEngine;

	
    @Value("${spring.mail.username}")
    private String EMAIL_SENDER;

	@Autowired
	public NotificationService(JavaMailSender javaMailSender, TemplateEngine templateEngine) {
		this.javaMailSender = javaMailSender;
		this.templateEngine = templateEngine;
		templateEngine.addLinkBuilder(new ILinkBuilder() {

		    @Override
		    public String getName() {
		        return null;
		    }

		    @Override
		    public Integer getOrder() {
		        return null;
		    }

		    @Override
		    public String buildLink(IExpressionContext context, String base, Map<String, Object> parameters) {
		        return null;
		    }

			
		});
	}

	public void sendRegistrationNotification(User user) {
		JSONObject jsonObject = new JSONObject();
		
		try {
			jsonObject.put("title", "Welcome");
			jsonObject.put("header", "Welcome " + user.getFirstName());
			jsonObject.put("message", "Your Verification OTP is : " + user.getVerificationOtp()); 
			jsonObject.put("verification_message", " Kindly Proceed with your verification OTP " );
			
			jsonObject.put("verification_hash",  user.getFirstName());
			jsonObject.put("footer_message", "Thank you for choosing Nova");
			jsonObject.put("recipient", user.getEmail());
			jsonObject.put("subject", "NOVA Registration");
			jsonObject.put("template", "Email/spearhead/welcome");

			this.sendNotification(jsonObject);
		} catch (MessagingException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
	}


	public void sendNotification(JSONObject message) throws MessagingException {
		
		try {
			Context context = new Context();
			context.setVariable("message", message.getString("message"));
			context.setVariable("title", message.getString("title"));
			context.setVariable("header", message.getString("header"));
			context.setVariable("verification_message", message.getString("verification_message"));
			context.setVariable("verification_hash", message.getString("verification_hash"));
			context.setVariable("footer_message", message.getString("footer_message"));

			String process = templateEngine.process(message.getString("template"), context);
			javax.mail.internet.MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
			helper.setSubject(message.getString("subject"));


			helper.setText(process, true);
			helper.setFrom(EMAIL_SENDER);
			helper.setTo(message.getString("recipient"));
			javaMailSender.send(mimeMessage);
		} catch (JSONException e) {
			
			System.out.println(e.getMessage());
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
	}
}
