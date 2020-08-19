package com.pojo;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Passage {
    private Integer id;

    private Integer userId;

    private String title;

    private String content;

    private String coverImage;

    private Integer praiseCount;

    private String praideId;

    private Integer collectedCount;

    private String collectId;

    private Integer commentCount;

    private Date time;

    public Passage(Integer id, Integer userId, String title, String content, String coverImage, Integer praiseCount, String praideId, Integer collectedCount, String collectId, Integer commentCount, Date time) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.coverImage = coverImage;
        this.praiseCount = praiseCount;
        this.praideId = praideId;
        this.collectedCount = collectedCount;
        this.collectId = collectId;
        this.commentCount = commentCount;
        this.time = time;
    }

    public Passage() {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage == null ? null : coverImage.trim();
    }

    public Integer getPraiseCount() {
        return praiseCount;
    }

    public void setPraiseCount(Integer praiseCount) {
        this.praiseCount = praiseCount;
    }

    public String getPraideId() {
        return praideId;
    }

    public void setPraideId(String praideId) {
        this.praideId = praideId == null ? null : praideId.trim();
    }

    public Integer getCollectedCount() {
        return collectedCount;
    }

    public void setCollectedCount(Integer collectedCount) {
        this.collectedCount = collectedCount;
    }

    public String getCollectId() {
        return collectId;
    }

    public void setCollectId(String collectId) {
        this.collectId = collectId == null ? null : collectId.trim();
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}