package org.iut.montreuil.Service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.iut.montreuil.bean.Annonce;
import org.iut.montreuil.connection.HibernateUtil;

import java.util.List;

public class AnnonceService {

    public static AnnonceService instance = null;

    public static AnnonceService getInstance() {
        if(instance == null){
            instance = new AnnonceService();
        }
        return instance;
    }
    public void saveAnnonce(Annonce annonce) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(annonce);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateAnnonce(Annonce annonce) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.update(annonce);
            tx.commit();
        }
    }

    public List<Annonce> getAnnonces() {
        List<Annonce> annonces = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            annonces = session.createQuery("from Annonce", Annonce.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return annonces;
    }

    public Annonce getAnnonceById(int id) {
        Annonce annonce = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            annonce = session.get(Annonce.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return annonce;

    }

    public void deleteAnnonce(Annonce annonce) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.delete(annonce);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
