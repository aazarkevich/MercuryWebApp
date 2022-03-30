package mercuryWebApp.controllers;

import mercuryWebApp.models.Data;
import mercuryWebApp.models.Podstation;
import mercuryWebApp.service.DataService;
import mercuryWebApp.service.DeviceService;
import mercuryWebApp.service.PodstationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@Controller
@RequestMapping("/mercuryTcp")
public class MercuryTcpController {
    private final DataService dataService;
    private final DeviceService deviceService;
    private final PodstationService podstationService;

    @Autowired
    public MercuryTcpController(DataService dataService, DeviceService deviceService, PodstationService podstationService) {
        this.dataService = dataService;
        this.deviceService = deviceService;
        this.podstationService = podstationService;
    }

    @GetMapping("/{date}")
    public String showValues(@PathVariable("date") Date date, Model model) {
        model.addAttribute("valuesList", dataService.valuesChoiseDay(date));
        return "mercuryTcp/mercuryTcpData";
    }

    @GetMapping("/podstations/{id}")
    public String podstations(@PathVariable("id") long id,Model model) {
        model.addAttribute("parentPodstations", podstationService.parentPodstation());
        model.addAttribute("podstation", podstationService.readPodstation(id));
        model.addAttribute("childrenPodstation", podstationService.childrenPodstation(id));
        return "mercuryTcp/podstations";
    }

    @PostMapping("/podstations")
    public String createPodstation(@ModelAttribute("podstation") Podstation podstation) {
        System.out.println(podstation);
        return "redirect:/podstations/2";
    }
}