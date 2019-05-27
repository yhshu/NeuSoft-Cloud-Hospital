package com.neusoft.medical.bean;

public class Doctor {
    private Integer id;

    private String name;

    private Integer department;

    private Integer type;

    private Integer title;

    private Integer scheduling;

    public Doctor(Integer id, String name, Integer department, Integer type, Integer title, Integer scheduling) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.type = type;
        this.title = title;
        this.scheduling = scheduling;
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

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getTitle() {
        return title;
    }

    public void setTitle(Integer title) {
        this.title = title;
    }

    public Integer getScheduling() {
        return scheduling;
    }

    public void setScheduling(Integer scheduling) {
        this.scheduling = scheduling;
    }
}