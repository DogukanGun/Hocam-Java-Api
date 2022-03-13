package com.dag.hocam.sec.enums;

import com.dag.hocam.model.entity.User;

public enum UserType {

    ADMIN("admin"),
    USER("user");

    private String label;

    public String getLabel(){
        return this.label;
    }

    UserType(String label){
        this.label = label;
    }
}
