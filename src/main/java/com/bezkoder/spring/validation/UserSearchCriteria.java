package com.bezkoder.spring.validation;

public class UserSearchCriteria {
    private String name;
    private Integer age;
    private String city;
    private String sortBy;
    private String sortOrder;

    public UserSearchCriteria() {
    }

    public UserSearchCriteria(String name, Integer age, String city, String sortBy, String sortOrder) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.sortBy = sortBy;
        this.sortOrder = sortOrder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }
}