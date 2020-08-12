package com.xx.designpattern.StructuralPattern.Bridge;

/**
 * @author xiaoxinga
 * @date 2020/06/08 10:40
 * @since
 */
public class AirConditioner implements ElectricAppliance {
    private final String name = "空调";

    @Override
    public String description() {
        return name;
    }
}
