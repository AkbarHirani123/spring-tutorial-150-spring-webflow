package com.caveofprogramming.spring.web.test.tests;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.caveofprogramming.spring.web.dao.Message;
import com.caveofprogramming.spring.web.dao.MessagesDao;
import com.caveofprogramming.spring.web.dao.OffersDao;
import com.caveofprogramming.spring.web.dao.User;
import com.caveofprogramming.spring.web.dao.UsersDao;

@ActiveProfiles("dev")
@ContextConfiguration(locations = {
		"classpath:com/caveofprogramming/spring/web/config/dao-context.xml",
		"classpath:com/caveofprogramming/spring/web/config/security-context.xml",
		"classpath:com/caveofprogramming/spring/web/test/config/datasource.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class MessageDaoTests {

	@Autowired
	private OffersDao offersDao;

	@Autowired
	private UsersDao userDao;

	@Autowired
	private MessagesDao messagesDao;

	@Autowired
	private DataSource dataSource;

	private User user1 = new User("akbarhirani", "akbar hirani", "123456",
			"akbar@hirani.com", true, "ROLE_USER");
	private User user2 = new User("deanwinchester", "dean winchester",
			"123456", "akbar@hirani.com", true, "ROLE_ADMIN");
	private User user3 = new User("barryallen", "barry allen", "123456",
			"akbar@hirani.com", true, "ROLE_USER");
	private User user4 = new User("oliverqueen", "oliver queen", "123456",
			"akbar@hirani.com", false, "user");

	@Before
	public void init() {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);

		jdbc.execute("delete from offer");
		jdbc.execute("delete from messages");
		jdbc.execute("delete from users");
	}

	@Test
	public void testSave() {
		userDao.create(user1);
		userDao.create(user2);
		userDao.create(user3);
		userDao.create(user4);

		Message message1 = new Message("Test subject 1", "Test content 1",
				"Akbar Hirani", "akbar@hirani.com", user1.getUsername());
		
		messagesDao.saveOrUpdate(message1);
	}

}
