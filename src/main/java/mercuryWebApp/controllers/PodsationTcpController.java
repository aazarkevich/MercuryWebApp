package mercuryWebApp.controllers;

import mercuryWebApp.models.Device;
import mercuryWebApp.models.Podstation;
import mercuryWebApp.service.DeviceService;
import mercuryWebApp.service.PodstationService;
import mercuryWebApp.service.ResService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mercuryTcp/podstations")
public class PodsationTcpController {
    private final DeviceService deviceService;
    private final PodstationService podstationService;
    private final ResService resService;

    @Autowired
    public PodsationTcpController(DeviceService deviceService, PodstationService podstationService, ResService resService) {
        this.deviceService = deviceService;
        this.podstationService = podstationService;
        this.resService = resService;
    }

    @GetMapping()
    public String podstations(Model model) {
        model.addAttribute("parentPodstations", podstationService.parentPodstation());
        model.addAttribute("podstation", new Podstation());
        return "mercuryTcp/podstations";
    }

    @GetMapping("/{id}")
    public String showPodstation(@PathVariable("id") long id, Model model) {
        model.addAttribute("parentPodstations", podstationService.parentPodstation());
        model.addAttribute("podstation", podstationService.readPodstation(id));
        model.addAttribute("childrenPodstation", podstationService.childrenPodstation(id));

        model.addAttribute("newPodstation", new Podstation());
        model.addAttribute("newDevice", new Device());
        return "mercuryTcp/showPodstation";
    }

    @PostMapping()
    public String createPodstation(@ModelAttribute Podstation podstation, @RequestParam Long resId) {
        podstation.setTypeConnection("T");
        Long idNewPodstation = podstationService.savePodstation(podstation, resId);
        return "redirect:/mercuryTcp/podstations/" + idNewPodstation;
    }

    @PostMapping("/{id}")
    public String createChildrenPodstation(@ModelAttribute Podstation podstation,
                                           @ModelAttribute Device device,
                                           @PathVariable Long id) {
        podstationService.saveChildrenPodstation(podstation, device, id);
        return "redirect:/mercuryTcp/podstations/" + id;
    }

    @GetMapping("/delete/{id}")
    public String deleteParentPodstation(@PathVariable Long id) {
        podstationService.deleteById(id);
        return "redirect:/mercuryTcp/podstations";
    }

    @PostMapping("edit/{id}")
    public String editParentPodstation(@PathVariable Long id,
                                       @ModelAttribute Podstation podstation,
                                       @ModelAttribute Device device) {

        System.out.println(podstation);
        System.out.println(device);
        System.out.println("Test ");
        return "redirect:/mercuryTcp/podstations/" + id;
    }
}
