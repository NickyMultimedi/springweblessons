package be.multimedi.weblessons.customer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;

@Controller
@RequestMapping("/customer")
@SessionScope
public class CustomerController {
    private static final String VIEW = "customer/customer";

    @ModelAttribute("cust")
    public Customer getCustomer() {
        return new Customer();
    }

    @GetMapping
    public String handleGet() {
        return VIEW;
    }

    @PostMapping(params = {"register"})
    public String handleCustomer(@ModelAttribute("cust") Customer customer) {
        return VIEW;
    }
}
