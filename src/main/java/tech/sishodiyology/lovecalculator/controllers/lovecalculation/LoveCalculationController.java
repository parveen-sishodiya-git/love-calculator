package tech.sishodiyology.lovecalculator.controllers.lovecalculation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import tech.sishodiyology.lovecalculator.model.Love;

@Controller
public class LoveCalculationController {

	@RequestMapping("/process-lovecalculation")
	public String calculateLove(@ModelAttribute("love") Love love) {
		return "lovecalculation-result";
	}
	
}
