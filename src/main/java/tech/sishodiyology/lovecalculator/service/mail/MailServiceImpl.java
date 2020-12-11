package tech.sishodiyology.lovecalculator.service.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService{

	@Autowired
	JavaMailSender mailSender;
	
	@Override
	public void sendMail(String to) {
		SimpleMailMessage mailMessage =  new SimpleMailMessage();
		mailMessage.setTo(to);
		mailMessage.setFrom("sishodiya.official@gmail.com");
		mailMessage.setText("Hello this is my mail body... \nRegards, \nParveen Sishodiya");
		mailSender.send(mailMessage);
	}
}
