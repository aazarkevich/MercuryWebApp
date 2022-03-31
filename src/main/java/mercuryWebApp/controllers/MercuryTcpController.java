package mercuryWebApp.controllers;

import mercuryWebApp.models.Podstation;
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
    private final DeviceService deviceService;
    private final PodstationService podstationService;
    private final ResService resService;

    @Autowired
    public MercuryTcpController(DataService dataService, DeviceService deviceService, PodstationService podstationService, ResService resService) {
        this.dataService = dataService;
        this.deviceService = deviceService;
        this.podstationService = podstationService;
        this.resService = resService;
    }

    @GetMapping("/{date}")
    public String showValues(@PathVariable("date") Date date, Model model) {
        model.addAttribute("valuesList", dataService.valuesChoiseDay(date));
        return "mercuryTcp/TcpData";
    }

    @GetMapping("/podstations")
    public String podstations(Model model) {
        model.addAttribute("parentPodstations", podstationService.parentPodstation());
        model.addAttribute("podstation", new Podstation());
        model.addAttribute("resList", resService.allRes());
        return "mercuryTcp/podstations";
    }

    @GetMapping("/podstations/{id}")
    public String showPodstations(@PathVariable("id") long id,Model model) {
        model.addAttribute("parentPodstations", podstationService.parentPodstation());
        model.addAttribute("podstation", podstationService.readPodstation(id));
        model.addAttribute("childrenPodstation", podstationService.childrenPodstation(id));
        return "mercuryTcp/showPodstation";
    }

    @PostMapping("/podstations")
    public String createPodstation(@ModelAttribute Podstation podstation) {
//        Podstation newPodstation = new Podstation();
//        podstation.setResByResId(resService.allRes().get(0));
        System.out.println(podstation);
        return "redirect:/mercuryTcp/podstation";
    }
}