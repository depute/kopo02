package com.test.test23;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.test23.domain.User;
import com.test.test23.impl.UserHibernateProviderImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	private UserProvider provider;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		User user=new User("demonpark","테스트","어딘가");
		provider=new UserHibernateProviderImpl();
		provider.insertUser(user);
		List<User> users=provider.findAllUsers();
		assertNotNull(users);
		assertEquals("demonpark",users.get(0).getUserId());
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
