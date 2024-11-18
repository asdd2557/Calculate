package org.example.contoller;

import org.example.method.Divide_Method;
import org.example.resource.Calculrate_Interface;

import java.util.HashMap;
import java.util.Map;

public class Calculator_Controller {

    private final Map<String, Calculrate_Interface> calculrate_InterfaceMap = new HashMap<>();

    public void addOperation(String operator, Calculrate_Interface calculrate_interface){
        calculrate_InterfaceMap.put(operator, calculrate_interface);
    }

    public int calculate(int a, int b, String operator){
        Calculrate_Interface calculrate_interface = calculrate_InterfaceMap.get(operator);
        if(calculrate_interface == null){
            throw new UnsupportedOperationException("인터페이스가 Null입니다.");
        }
        return calculrate_interface.Event(a,b);
    }

}
