package be.multimedi.weblessons.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Controller
//@Scope()
public class HelloThymeleafController implements HelloController {
    Hello helloService;

    @Autowired
    public void setHelloService(Hello helloService) {
        this.helloService = helloService;
    }

    @PostConstruct
    public void init() {
        System.out.println("Construction is imminent.");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destruction is a fact, Blame Tony");
    }

    @Override
    @RequestMapping("hello")
    public ModelAndView handleHello() {
        String hello = helloService.sayHello();
        return new ModelAndView("helloView", "message", hello);
    }
}
