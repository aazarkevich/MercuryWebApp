package mercuryWebApp.service;

import mercuryWebApp.dao.ResDao;
import mercuryWebApp.models.Res;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResService {
    @Autowired
    private ResDao resDao;

    public List<Res> allRes() {
        return resDao.allRes();
    }
}
