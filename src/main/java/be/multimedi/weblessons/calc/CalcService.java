package be.multimedi.weblessons.calc;

import org.springframework.stereotype.Service;

@Service
public class CalcService {

    public int sum(int a, int b) {
        return a + b;
    }
}
