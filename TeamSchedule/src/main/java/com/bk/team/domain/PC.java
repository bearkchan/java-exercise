package com.bk.team.domain;

public class PC implements Equipment{
    /**
     * 机器的型号
     */
    private String model;

    /**
     * 显示器名称
     */
    private String display;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public PC(String model, String display) {
        this.model = model;
        this.display = display;
    }

    @Override
    public String getDescription() {
        return "机器型号："+model+", 显示器名称: "+ display;

    }
}
