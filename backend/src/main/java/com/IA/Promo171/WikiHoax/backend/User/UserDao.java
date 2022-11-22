package com.IA.Promo171.WikiHoax.backend.User;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDao {

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

public User getUser(Long id) {
  Session session = this.sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery("From User user where user.id = :id", User.class).setParameter("id",
                id);
        return query.getSingleResult();
}

public String getUserMdp(String identifiant){
  Session session = this.sessionFactory.getCurrentSession();
        Query<String> query = session.createQuery("SELECT mdp From User user where user.identifiant = :identifiant", String.class).setParameter("identifiant",
        identifiant);
        return query.getSingleResult();
}

}