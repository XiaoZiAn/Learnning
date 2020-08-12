package com.xx.designpattern.StructuralPattern.Bridge;

/**
 * @author xiaoxinga
 * @date 2020/06/08 10:43
 * @since
 */
public abstract class Brand {
    protected ElectricAppliance electricAppliance;

    public Brand(ElectricAppliance electricAppliance) {
        this.electricAppliance = electricAppliance;
    }

    abstract String description();
}
