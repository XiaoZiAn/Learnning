package com.xx.designpattern.StructuralPattern.Bridge;

/**
 * @author xiaoxinga
 * @date 2020/06/08 10:43
 * @since
 */
public class Gree extends Brand {
    private final String name = "格力";

    public Gree(ElectricAppliance electricAppliance) {
        super(electricAppliance);
    }

    @Override
    String description() {
        return name + electricAppliance.description();
    }
}
