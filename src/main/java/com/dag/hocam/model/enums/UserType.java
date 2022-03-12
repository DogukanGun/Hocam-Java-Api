package com.dag.hocam.model.enums;

public enum UserType {
    USER("U"),
    ADMIN("A"),
    TEACHER("T");

    public final String label;

    private UserType(String label) {
        this.label = label;
    }
}
