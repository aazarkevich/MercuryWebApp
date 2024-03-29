package mercuryWebApp.dao;

import mercuryWebApp.models.Podstation;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PodstationDaoImpl implements PodstationDao {
    private  static final Logger loger = LoggerFactory.getLogger(PodstationDaoImpl.class);

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
    public Long save(Podstation podstation) {
        Long id = (Long) getSession().save(podstation);
        return id;
    }

    @Override
    public Podstation read(long id) {
        Podstation podstation = (Podstation) getSession().createQuery("from Podstation where id = :id").setParameter("id", id).getSingleResult();
        loger.info("Get podstation" + podstation);
        return podstation;
    }

    @Override
    public void update(Podstation podstation) {
        getSession().update(podstation);
    }

    @Override
    public void delete(Podstation podstation) {
        getSession().delete(podstation);
    }

    @Override
    public List<Podstation> allPodstation() {
        return getSession().createQuery("from Podstation ").list();
    }

    @Override
    public List<Podstation> allPodstationRes() {
        return null;
    }

    @Override
    public List<Podstation> childrenPodstation(long parentId) {
        return getSession().createQuery("from Podstation where parentId = :parentId").setParameter("parentId", parentId).list();
    }

    @Override
    public List<Podstation> parentPodstation() {
        return getSession().createQuery("from Podstation  where parentId = null and typeConnection = 'T' ").list();
    }

}
