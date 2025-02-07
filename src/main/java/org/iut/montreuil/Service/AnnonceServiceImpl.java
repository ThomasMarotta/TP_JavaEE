package org.iut.montreuil.Service;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.iut.montreuil.Interface.AnnonceService;
import org.iut.montreuil.bean.Annonce;
import org.iut.montreuil.connection.HibernateUtil;

import java.util.List;

public class AnnonceServiceImpl implements AnnonceService {

    private static AnnonceServiceImpl instance = null;

    public static AnnonceServiceImpl getInstance() {
        if(instance == null){
            instance = new AnnonceServiceImpl();
        }
        return instance;
    }

    @Override
    public void saveAnnonce(Annonce annonce) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(annonce);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateAnnonce(Annonce annonce) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.update(annonce);
            tx.commit();
        }
    }

    @Override
    public List<Annonce> getAnnonces() {
        List<Annonce> annonces = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            annonces = session.createQuery("from Annonce", Annonce.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return annonces;
    }

    @Override
    public Annonce getAnnonceById(int id) {
        Annonce annonce = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            annonce = session.get(Annonce.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return annonce;

    }

    @Override
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
