package mercuryWebApp.dao;

import mercuryWebApp.models.Podstation;

import java.util.List;

public interface PodstationDao {
    void save(Podstation podstation);

    Podstation read(long id);

    void update(Podstation podstation);

    void delete(Podstation podstation);

    List<Podstation> allPodstation();

    List<Podstation> allPodstationRes();

    List<Podstation> childrenPodstation(long parentId);

    List<Podstation> parentPodstation();
}
