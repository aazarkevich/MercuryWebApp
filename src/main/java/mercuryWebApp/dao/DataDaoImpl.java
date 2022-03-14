package mercuryWebApp.dao;

import mercuryWebApp.models.Data;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataDaoImpl implements DataDao{
    private  static final Logger loger = LoggerFactory.getLogger(DataDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        try {
            return sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            return sessionFactory.openSession();
        }
    }
    @Override
    public void save(Data data) {
        getSession().beginTransaction();
        getSession().save(data);
        getSession().getTransaction().commit();
    }

    @Override
    public Data read(int id) {
        Data data = (Data) getSession().createQuery("from Data where id = " + id).getSingleResult();
        loger.info("Get data" + data);
        return data;
    }

    @Override
    public void update(Data data) {
        getSession().beginTransaction();
        getSession().update(data);
        getSession().getTransaction().commit();
        loger.info("Update succesfully " + data);
    }

    @Override
    public void delete(Data data) {
        getSession().beginTransaction();
        getSession().delete(data);
        getSession().getTransaction().commit();
        loger.info("Delete succesfully");
    }

    @Override
    public List<Data> allDataToDay() {
        java.sql.Date toDay = new java.sql.Date(new java.util.Date().getTime());
        return getSession().createQuery("from Data where date = " + toDay.toString()).list();
    }
}
