package be.multimedi.weblessons.vehicules;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/vehicules")
public class VehiculeController {
    private static final String REGISTRATION = "/vehicules/registration";
    private static final String REGISTERED = "/vehicules/registered";

    @GetMapping
    public String firstRequest(@ModelAttribute("vehicule") Vehicule vehicule) {
        return REGISTRATION;
    }

    @PostMapping
    public String handleRegistrationForm(@Valid @ModelAttribute("vehicule") Vehicule vehicule, BindingResult validation) {
        System.out.println(vehicule);
        if (validation.hasErrors()) {
            return REGISTRATION;
        }
        return REGISTERED;
    }


}
