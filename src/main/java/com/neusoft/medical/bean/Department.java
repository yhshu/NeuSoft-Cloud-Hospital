package com.neusoft.medical.bean;

public class Department {
    private Integer id;

    private String name;

    private String category;

    public Department(Integer id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }
}