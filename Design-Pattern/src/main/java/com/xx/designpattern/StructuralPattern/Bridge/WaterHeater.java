package com.xx.designpattern.StructuralPattern.Bridge;

/**
 * @author xiaoxinga
 * @date 2020/06/08 10:42
 * @since
 */
public class WaterHeater implements ElectricAppliance {
    private final String name = "热水器";

    @Override
    public String description() {
        return name;
    }
}
