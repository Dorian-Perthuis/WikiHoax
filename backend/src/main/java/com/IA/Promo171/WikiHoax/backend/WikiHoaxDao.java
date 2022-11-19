package com.IA.Promo171.WikiHoax.backend;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class WikiHoaxDao {

@Autowired
private SessionFactory sessionFactory;

public List<User> listUser() {
  Session session = this.sessionFactory.getCurrentSession();
  Query<User> query = session.createQuery("From User", User.class);
  return query.getResultList();
}

public User newUser(User newUser) {
  Session session = this.sessionFactory.getCurrentSession();
  session.save(newUser);
  return newUser;
}

public List<Page> listElement() {
  Session session = this.sessionFactory.getCurrentSession();
  Query<Page> query = session.createQuery("From Page", Page.class);
  return query.getResultList();
}

public Page newElement(Page newElement) {
  Session session = this.sessionFactory.getCurrentSession();
  session.save(newElement);
  return newElement;
}

}