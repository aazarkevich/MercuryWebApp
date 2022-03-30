package mercuryWebApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("date", new java.sql.Date(new java.util.Date().getTime()));
        return "index.html";
    }
}
