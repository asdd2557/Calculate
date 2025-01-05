package org.example.method;

import org.example.resource.CalculrateInterface;

public class MinusMethod implements CalculrateInterface {
    @Override
    public int Event(int a, int b){
        return a-b;
    }
}