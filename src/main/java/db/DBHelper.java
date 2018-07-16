package db;

import models.Article;
import models.Journalist;
import org.hibernate.*;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBHelper {

    private static Transaction transaction;
    private static Session session;

    public static void save(Object object) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(object);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static <T> List<T> getList(Criteria criteria) {
        List<T> results = null;
        try {
            transaction = session.beginTransaction();
            results = criteria.list();
            ;
            transaction.commit();
        } catch (HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }

    public static <T> T getUnique(Criteria criteria) {
        T result = null;
        try {
            transaction = session.beginTransaction();
            result = (T) criteria.uniqueResult();
            ;
            transaction.commit();
        } catch (HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

    public static <T> void deleteAll(Class classType) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            Criteria cr = session.createCriteria(classType);
            List<T> results = cr.list();
            for (T result : results) {
                session.delete(result);
            }
            transaction.commit();
        } catch (HibernateException ex) {
            transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }


    public static void delete(Object object) {
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.delete(object);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static <T> List<T> getAll(Class classType) {
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(classType);
        cr.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        return getList(cr);
    }

    public static <T> T find(int id, Class classType) {
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(classType);
        cr.add(Restrictions.eq("id", id));
        return getUnique(cr);

    }

    public static List<Article> getAllArticlesWrittenByJournalist(Journalist journalist){
        session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Article.class);
        criteria.add(Restrictions.eq("journalist", journalist));
        return getList(criteria);
    }

    //Method to order the articles by hits

    public static List<Article> orderByArticleHits() {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Article> articles = null;
        try {
            Criteria cr = session.createCriteria(Article.class);
            cr.addOrder(Order.desc("articleHits"));
            articles = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return articles;
    }

    //Method to order articles by their published date

    public static List<Article> orderByPublishDate() {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Article> articles = null;
        try {
            Criteria cr = session.createCriteria(Article.class);
            cr.addOrder(Order.desc("publishDate"));
            articles = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return articles;
    }

    // Method to use the search bar

    public static List<Article> searchArticlesTitle(String search) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Article> results = null;
        try {
            Criteria cr = session.createCriteria(Article.class);
            cr.add(Restrictions.ilike("title", "%" + search + "%"));
            results = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        if (results.size() > 0) {
            return results;}
        else return null;
    }



    }
