package be.multimedi.weblessons.calc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/calc")
public class CalculatorController {
    private static final String VIEW = "calc/calculator";
    CalcService service;

    @Autowired
    public void setService(CalcService service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView handleGetCalc() {
        return new ModelAndView(VIEW);
    }

    @PostMapping
    public ModelAndView handlePostCalc(@RequestParam(value = "number_one", defaultValue = "0") Integer nr1, @RequestParam(value = "number_two", defaultValue = "0") Integer nr2) {
        Integer sum = service.sum(nr1, nr2);
        return new ModelAndView(VIEW, "number_eq", sum);
    }
}
