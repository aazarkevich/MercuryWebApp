package mercuryWebApp.controllers;

import mercuryWebApp.dao.DeviceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mercuryTcp")
public class MercuryTcpController {
    private final DeviceDao deviceDao;

    @Autowired
    public MercuryTcpController(DeviceDao deviceDao) {
        this.deviceDao = deviceDao;
    }


}
