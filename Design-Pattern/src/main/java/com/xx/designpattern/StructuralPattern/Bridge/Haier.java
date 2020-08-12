package com.xx.designpattern.StructuralPattern.Bridge;

/**
 * @author xiaoxinga
 * @date 2020/06/08 10:45
 * @since
 */
public class Haier extends Brand {

    private final String name = "海尔";

    public Haier(ElectricAppliance electricAppliance) {
        super(electricAppliance);
    }

    @Override
    public String description() {
        return name + electricAppliance.description();
    }
}
