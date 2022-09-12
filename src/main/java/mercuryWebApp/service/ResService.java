package mercuryWebApp.service;

import mercuryWebApp.dao.ResRepository;
import mercuryWebApp.exceptions.ResException;
import mercuryWebApp.models.Res;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

@Service
public class ResService {

    private final ResRepository resRepository;

    @Autowired
    public ResService(ResRepository resRepository) {
        this.resRepository = resRepository;
    }

    public Res getResById(Long id) {
        return resRepository.findById(id).orElseThrow(() -> new ResException("Unable to find res with id " + id));
    }

}
