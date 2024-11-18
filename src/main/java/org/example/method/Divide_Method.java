package org.example.method;

import org.example.resource.Calculrate_Interface;


public class Divide_Method implements Calculrate_Interface {
   @Override
    public int Event(int a, int b){
        if(a == 0 || b == 0){
            throw new ArithmeticException("0이 포함되어 있습니다.");
        }
        return a/b;
    }
}
