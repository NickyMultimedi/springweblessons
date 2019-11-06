package be.multimedi.weblessons.hello;

import org.springframework.stereotype.Service;

@Service("hello")
public class HelloService implements Hello {
    @Override
    public String sayHello() {
        return "Hello World!";
    }
}
