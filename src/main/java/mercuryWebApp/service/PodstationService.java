package mercuryWebApp.service;

import mercuryWebApp.dao.PodstationDao;
import mercuryWebApp.models.Podstation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PodstationService {
    @Autowired
    private PodstationDao podstationDao;

    public void savePodstation(Podstation podstation) {
        podstationDao.save(podstation);
    }

    public Podstation readPodstation(int id) {
        return podstationDao.read(id);
    }

    public void updatePoddstation(Podstation podstation) {
        podstationDao.update(podstation);
    }

    public void delete(Podstation podstation) {
        podstationDao.delete(podstation);
    }

    public List<Podstation> allPodstation() {
        return podstationDao.allPodstation();
    }
}
