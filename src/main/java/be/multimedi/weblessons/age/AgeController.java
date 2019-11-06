package be.multimedi.weblessons.age;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/age")
public class AgeController {
    @GetMapping
    public String handleAgeGet() {
        return "age/age";
    }

    @PostMapping(params = {"Submit", "category=child"})
    public String handleChild() {
        return "age/child";
    }

    @PostMapping(params = {"Submit", "category=teen"})
    public String handleTeen() {
        return "age/teen";
    }

    @PostMapping(params = {"Submit", "category=adult"})
    public String handleAdult() {
        return "age/adult";
    }

    @PostMapping(params = {"Cancel"})
    public String handleCancel() {
        return "age/cancel";
    }

    @PostMapping()
    public String handleDefault() {
        return "redirect:age";
    }
}
