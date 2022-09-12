package mercuryWebApp.controllers;

import mercuryWebApp.models.Device;
import mercuryWebApp.models.Podstation;
import mercuryWebApp.models.Res;
import mercuryWebApp.service.DataService;
import mercuryWebApp.service.DeviceService;
import mercuryWebApp.service.PodstationService;
import mercuryWebApp.service.ResService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@Controller
@RequestMapping("/mercuryTcp")
public class MercuryTcpController {
    private final DataService dataService;


    @Autowired
    public MercuryTcpController(DataService dataService, DeviceService deviceService, PodstationService podstationService, ResService resService) {
        this.dataService = dataService;
    }

    @GetMapping("/{date}")
    public String showValues(@PathVariable("date") Date date, Model model) {
        model.addAttribute("valuesList", dataService.valuesChoiseDay(date));
        return "mercuryTcp/TcpData";
    }


}