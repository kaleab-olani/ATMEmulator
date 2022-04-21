package com.emu.bank_service.models;

public enum AuthType {
    PIN("pin"),
    FINGER_PRINT ("fp");

    public final String value;
    AuthType(String value) {
        this.value = value;
    }
}
