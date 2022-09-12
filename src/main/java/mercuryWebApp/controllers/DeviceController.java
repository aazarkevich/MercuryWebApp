package mercuryWebApp.controllers;

import mercuryWebApp.models.Device;
import mercuryWebApp.models.Podstation;
import mercuryWebApp.service.DeviceService;
import mercuryWebApp.service.PodstationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mercuryTCP/device")
public class DeviceController {
    private PodstationService podstationService;

    private DeviceService deviceService;

    @Autowired
    public DeviceController(PodstationService podstationService, DeviceService deviceService) {
        this.podstationService = podstationService;
        this.deviceService = deviceService;
    }

    @PostMapping("/{id}")
    public String addDevice(@PathVariable Long id,
                            @ModelAttribute Podstation podstation,
                            @ModelAttribute Device device) {


        return "redirect:/mercuryTcp/podstations/" + id;
    }
}
