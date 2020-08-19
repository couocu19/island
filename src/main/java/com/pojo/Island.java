package com.pojo;

import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class Island {
    private Integer id;

    private Boolean type;

    private Integer accountUser;

    private Integer userId;

    private String locate;

    private Date time;

    public Island(Integer id, Boolean type, Integer accountUser, Integer userId, String locate, Date time) {
        this.id = id;
        this.type = type;
        this.accountUser = accountUser;
        this.userId = userId;
        this.locate = locate;
        this.time = time;
    }

    public Island() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public Integer getAccountUser() {
        return accountUser;
    }

    public void setAccountUser(Integer accountUser) {
        this.accountUser = accountUser;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLocate() {
        return locate;
    }

    public void setLocate(String locate) {
        this.locate = locate == null ? null : locate.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}