package com.IA.Promo171.WikiHoax.backend;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class PageDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Page getPage(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Query<Page> query = session.createQuery("From Page personne where page.id = :id", Page.class).setParameter("id",
                id);
        return query.getSingleResult();
    }

    public Page newPage(Page newPage) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(newPage);
        return newPage;
    }

    public Page updatePage(Page newPage) {
        return null;
    }

    public Image newImage(Image newImage) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(newImage);
        return newImage;
    }
}
