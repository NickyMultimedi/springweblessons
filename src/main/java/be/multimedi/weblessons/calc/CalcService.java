package be.multimedi.weblessons.calc;

import org.springframework.stereotype.Service;

@Service
public class CalcService {

    public int sum(int a, int b) {
        return a + b;
    }
    public int subt(int a, int b) { return a - b; }
    public int multy(int a, int b) { return a * b; }
    public int div(int a, int b) {return a / b;}
}
