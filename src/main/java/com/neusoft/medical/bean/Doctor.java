package com.neusoft.medical.bean;

public class Doctor {
    private Integer id;

    private String name;

    private String level;

    public Doctor(Integer id, String name, String level) {
        this.id = id;
        this.name = name;
        this.level = level;
    }

    public Doctor() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }
}