package org.example.resource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalculrateResourceImpl {
    private int num1;

    private int num2;

    private int result;
    private boolean while_switch1 = true;
    private boolean while_switch2= true;
    private boolean while_switch3= true;


    public boolean while_switch1() {
        return while_switch1;
    }


    public boolean while_switch2() {
        return while_switch2;
    }


    public boolean while_switch3() {
        return while_switch3;
    }
}
