package org.example.contoller;

import org.example.resource.CalculrateInterface;

import java.util.HashMap;
import java.util.Map;

public class CalculatorController {

    private final Map<String, CalculrateInterface> calculrateInterfaceMap = new HashMap<>();

    public void addOperation(String operator, CalculrateInterface calculrateInterface){
        calculrateInterfaceMap.put(operator, calculrateInterface);
    }

    public int calculate(int a, int b, String operator){
        CalculrateInterface calculrateInterface = calculrateInterfaceMap.get(operator);
        if(calculrateInterface == null){
            throw new UnsupportedOperationException("인터페이스가 Null입니다.");
        }
        return calculrateInterface.Event(a,b);
    }

}
