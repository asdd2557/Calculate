package org.example.method;

import org.example.resource.CalculrateInterface;


public class DivideMethod implements CalculrateInterface {
   @Override
    public int Event(int a, int b){
        if(b == 0){
            throw new ArithmeticException("0이 포함되어 있습니다.");
        }
        return a/b;
    }
}
