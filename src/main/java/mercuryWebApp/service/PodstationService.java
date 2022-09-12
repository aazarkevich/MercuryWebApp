package mercuryWebApp.service;

import mercuryWebApp.dao.PodstationDao;
import mercuryWebApp.models.Device;
import mercuryWebApp.models.Podstation;
import mercuryWebApp.models.Res;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PodstationService {
    private PodstationDao podstationDao;

    private final ResService resService;

    @Autowired
    public PodstationService(PodstationDao podstationDao, ResService resService) {
        this.podstationDao = podstationDao;
        this.resService = resService;
    }

    public Long savePodstation(Podstation podstation, Long resId) {
        Res resById = resService.getResById(resId);
        podstation.setResByResId(resById);
        Long id = podstationDao.save(podstation);
        return id;
    }

    public Long saveChildrenPodstation(Podstation childrenPodstation, Device device, Long parentId) {
        Podstation parentPodstation = readPodstation(parentId);

        childrenPodstation.setId(0);
        device.setId(0);

        device.setPodstation(childrenPodstation);
        device.setRes(parentPodstation.getResByResId());

        childrenPodstation.setTypeConnection(parentPodstation.getTypeConnection());
        childrenPodstation.setResByResId(parentPodstation.getResByResId());
        childrenPodstation.setParentId(parentId);
        childrenPodstation.setDevice(device);
        Long id = podstationDao.save(childrenPodstation);
        return id;
    }

    public Podstation readPodstation(long id) {
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

    public List<Podstation> childrenPodstation(long parentId) {
        return podstationDao.childrenPodstation(parentId);
    }

    public List<Podstation> parentPodstation() {
        return podstationDao.parentPodstation();
    }

    public void deleteById(Long deleteId) {
        Podstation deletePodstation = readPodstation(deleteId);
        List<Podstation> childrenPodstation = childrenPodstation(deleteId);
        if (!childrenPodstation.isEmpty()) {
            for (Podstation podstation : childrenPodstation) {
                delete(podstation);
                System.out.println("Test children");
            }
        }
        delete(deletePodstation);
    }
}
