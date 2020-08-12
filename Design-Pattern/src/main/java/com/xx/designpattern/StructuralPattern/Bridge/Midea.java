package com.xx.designpattern.StructuralPattern.Bridge;

/**
 * @author xiaoxinga
 * @date 2020/06/08 10:46
 * @since
 */
public class Midea extends Brand {

    private final String name = "美的";

    public Midea(ElectricAppliance electricAppliance) {
        super(electricAppliance);
    }

    @Override
    public String description() {
        return name + electricAppliance.description();
    }
}
