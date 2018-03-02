package com.test.test23.impl;

import java.util.List;

import org.hibernate.*;

import com.test.test23.UserProvider;
import com.test.test23.domain.User;
import com.test.test23.util.HibernateUtil;

public class UserHibernateProviderImpl implements UserProvider {
	public void insertUser(User user) {
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		session.persist(user);
		tx.commit();
		session.close();
	}

	@Override
	public List<User> findAllUsers() {
		Session session=HibernateUtil.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		List<User> users=session.createQuery("from User u order by u.name asc").list();
		tx.commit();
		session.close();
		return users;
	}

	@Override
	public User findUser(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(String userId, String updateName) {
		// TODO Auto-generated method stub
		return null;
	}
}
