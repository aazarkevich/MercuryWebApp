package mercuryWebApp.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import mercuryWebApp.models.Device;

import java.util.List;

@Repository
public class DevicesDaoImpl implements DeviceDao{
    private  static final Logger loger = LoggerFactory.getLogger(DevicesDaoImpl.class);

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
    public Device read(int id) {
        Device device = (Device) getSession().createQuery("from Device where id = " + id).getSingleResult();
        loger.info("Get device" + device);
        return device;
    }

    @Override
    public void save(Device device) {
        getSession().beginTransaction();
        getSession().save(device);
        getSession().getTransaction().commit();
        loger.info("Save succesfully " + device);
    }



    @Override
    public void update(Device device) {
        getSession().beginTransaction();
        getSession().update(device);
        getSession().getTransaction().commit();
        loger.info("Update succesfully " + device);
    }

    @Override
    public void delete(Device device) {
        getSession().beginTransaction();
        getSession().delete(device);
        getSession().getTransaction().commit();
        loger.info("Delete succesfully");
    }

    @Override
    public List<Device> allDevice() {
        return getSession().createQuery("from Device ").list();
    }
}
