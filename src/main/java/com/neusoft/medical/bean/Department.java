package com.neusoft.medical.bean;

public class Department {
    private Integer id;

    private String name;

    private Integer type;

    private Integer category;

    private Integer subType;

    public Department(Integer id, String name, Integer type, Integer category, Integer subType) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.category = category;
        this.subType = subType;
    }

    public Department() {
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getSubType() {
        return subType;
    }

    public void setSubType(Integer subType) {
        this.subType = subType;
    }
}