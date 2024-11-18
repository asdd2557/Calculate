package org.example.method;

import org.example.resource.Calculrate_Interface;

public class Minus_Method implements Calculrate_Interface {
    @Override
    public int Event(int a, int b){
        return a-b;
    }
}