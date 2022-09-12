package mercuryWebApp.dao;

import mercuryWebApp.models.Res;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResRepository extends CrudRepository<Res, Long> {
}
