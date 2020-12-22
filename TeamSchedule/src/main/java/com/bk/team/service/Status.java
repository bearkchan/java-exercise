package com.bk.team.service;

public class Status {
    @Override
    public String toString() {
        return NAME;
    }

    public String getNAME() {
        return NAME;
    }

    private final String NAME;

    public Status(String NAME) {
        this.NAME = NAME;
    }

    public static final Status FREE = new Status("FREE");
    public static final Status VOCATION = new Status("VOCATION");
    public static final Status BUSY = new Status("BUSY");
}
