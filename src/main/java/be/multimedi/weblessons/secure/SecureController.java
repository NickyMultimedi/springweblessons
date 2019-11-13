package be.multimedi.weblessons.secure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/security")
public class SecureController {
    private final static String SECRECY_PAGE = "secrecy/secret";

    @Autowired
    SecureBean secB;

    @GetMapping
    public String handleSecrecy(ModelMap model) {
        String secret = secB.getSecret();
        model.addAttribute("secret", secret);
        return SECRECY_PAGE;
    }
}
