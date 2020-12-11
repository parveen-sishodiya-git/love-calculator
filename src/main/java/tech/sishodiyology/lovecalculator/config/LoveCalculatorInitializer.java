package tech.sishodiyology.lovecalculator.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class LoveCalculatorInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	LoveCalculatorInitializer(){
		System.out.println("Fast initilizing");
	}
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		Class<?>[] arr = {LoveCalculatorConfiguration.class};
		return arr;
	}

	@Override
	protected String[] getServletMappings() {
		String arr[] = {"/lovecalculator.com/*","/lovecalculator.com","/lc.com/*","/"};
		return arr;
	}

}
