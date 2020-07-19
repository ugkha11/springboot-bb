package com.demo.springbootbb.Hello;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//controller
@RestController
public class HelloWorldController
{
	
	/*
	 * @Autowired private ResourceBundleMessageSource messageSource;
	 */
	
	
	//simple method
	//@RequestMapping(method = RequestMethod.GET,path="/helloworld1")
	@GetMapping("/helloworld1")
	public String helloworld()
	{
		return "hello world";
	}
	
	@GetMapping("/helloworld-bean")
	public UserDetails helloworldbean()
	{
		return new UserDetails("Osman","Khan","Finland"); 
	}
	
//	@GetMapping("/hello-int")
//	public String getMessageInI18NFormat(@RequestHeader(name = "Accept-Language", required = false) String locale) {
//		
//		//return messageSource.getMessage("label.hello",null, new Locale(locale));
//		//return "Hello world i18N";
//	}
	
	
	//i18N
	@Autowired
    MessageSource messageSource;
     
    @GetMapping("/hello-int")
    public String index(Locale locale) {
        return messageSource.getMessage("label.hello", null, locale);
    }
	
	
	
	
 
}
