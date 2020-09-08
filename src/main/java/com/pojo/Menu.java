package com.pojo;

public class Menu {
    private Integer id;

    private String menuName;

    private String uri;

    public Menu(Integer id, String menuName, String uri) {
        this.id = id;
        this.menuName = menuName;
        this.uri = uri;
    }

    public Menu() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri == null ? null : uri.trim();
    }
}