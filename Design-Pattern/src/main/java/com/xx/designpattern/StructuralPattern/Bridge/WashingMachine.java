package com.xx.designpattern.StructuralPattern.Bridge;

/**
 * @author xiaoxinga
 * @date 2020/06/08 10:41
 * @since
 */
public class WashingMachine implements ElectricAppliance {
    private final String name = "洗衣机";

    @Override
    public String description() {
        return name;
    }
}
