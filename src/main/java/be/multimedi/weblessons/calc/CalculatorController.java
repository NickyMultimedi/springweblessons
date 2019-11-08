package be.multimedi.weblessons.calc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/calc")
@SessionAttributes("solution")
public class CalculatorController {
    private static final String VIEW = "calc/calculator";
    CalcService service;
    Integer solution = 0;

    @ModelAttribute
    public int getSolution() {
        return solution;
    }

    @Autowired
    public void setService(CalcService service) {
        this.service = service;
    }

    @GetMapping
    public ModelAndView handleGetCalc(ModelMap model) {
        model.addAttribute("solution", 0);
        return new ModelAndView(VIEW);
    }

    @PostMapping(params = {"add"})
    public String handleAddition(@RequestParam(value = "value", defaultValue = "0") int value, ModelMap model) {
        solution = service.sum(solution, value);
        model.replace("solution", solution);
        return VIEW;
    }

    @PostMapping(params = {"subtract"})
    public String handleSubtraction(@RequestParam(value="value", defaultValue = "0") int value, ModelMap model) {
        solution = service.subt(solution, value);
        model.replace("solution", solution);
        return VIEW;
    }

    @PostMapping(params = {"multiply"})
    public String handleMultiplication(@RequestParam(value="value", defaultValue = "1") int value, ModelMap model) {
        solution = service.multy(solution, value);
        model.replace("solution", solution);
        return VIEW;
    }

    @PostMapping(params = {"divide"})
    public String handleDivision(@RequestParam(value="value", defaultValue = "1") int value, ModelMap model) {
        solution = service.div(solution, value);
        model.replace("solution", solution);
        return VIEW;
    }

    @PostMapping(params = {"reset"})
    public String handleReset(ModelMap model) {
        solution = 0;
        model.replace("solution", solution);
        return VIEW;
    }

//    @PostMapping
//    public ModelAndView handlePostCalc(@RequestParam(value = "number_one", defaultValue = "0") Integer nr1, @RequestParam(value = "number_two", defaultValue = "0") Integer nr2) {
//        Integer sum = service.sum(nr1, nr2);
//        return new ModelAndView(VIEW, "number_eq", sum);
//    }
}
