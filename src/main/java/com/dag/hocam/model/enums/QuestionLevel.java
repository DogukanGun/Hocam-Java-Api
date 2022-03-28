package com.dag.hocam.model.enums;

public enum QuestionLevel {

    EASY("easy"),
    MEDIUM("medium"),
    HARD("hard");

    public final String label;

    private QuestionLevel(String label) {
        this.label = label;
    }
}
