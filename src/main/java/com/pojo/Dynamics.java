package com.pojo;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Dynamics {
    private Integer id;

    private Integer userId;

    private String contents;

    private String images;

    private Integer praiseCount;

    private String prsiaeId;

    private Integer commentCount;

    private Boolean isDeleted;

    private Date time;

    public Dynamics(Integer id, Integer userId, String contents, String images, Integer praiseCount, String prsiaeId, Integer commentCount, Boolean isDeleted, Date time) {
        this.id = id;
        this.userId = userId;
        this.contents = contents;
        this.images = images;
        this.praiseCount = praiseCount;
        this.prsiaeId = prsiaeId;
        this.commentCount = commentCount;
        this.isDeleted = isDeleted;
        this.time = time;
    }

    public Dynamics() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents == null ? null : contents.trim();
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images == null ? null : images.trim();
    }

    public Integer getPraiseCount() {
        return praiseCount;
    }

    public void setPraiseCount(Integer praiseCount) {
        this.praiseCount = praiseCount;
    }

    public String getPrsiaeId() {
        return prsiaeId;
    }

    public void setPrsiaeId(String prsiaeId) {
        this.prsiaeId = prsiaeId == null ? null : prsiaeId.trim();
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}