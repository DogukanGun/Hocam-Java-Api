package com.dag.hocam.model.enums;

public enum AnswerType {
    A("A"),
    B("B"),
    C("C"),
    D("D"),
    E("E");

    public final String label;

    private AnswerType(String label) {
        this.label = label;
    }
}
