package tech.sishodiyology.lovecalculator.controllers.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import tech.sishodiyology.lovecalculator.model.LoveResultShare;
import tech.sishodiyology.lovecalculator.service.mail.MailService;

@Controller
public class MailController {

	@Autowired
	MailService mailService;
	
	@RequestMapping("/shareresult")
	public String shareResult(@ModelAttribute("loveresult") LoveResultShare share) {
		return "shareresult";
	}
	
	@RequestMapping("/process-result-sharing")
	public String sharingResult(@ModelAttribute("loveresult") LoveResultShare share) {
		mailService.sendMail(share.getShareEmail());
		return "shared-love-result";
	}
	
}
