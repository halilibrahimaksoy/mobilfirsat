package com.tecpoint.mobilfirsat.mobilfirsat.Model;

import java.util.Date;

/**
 * Created by Tuğba Tatlı on 19.11.2015.
 */
public class FeedItem {
    private String UserName;
    private String Title;
    private String Description;
    private String UserProfileImageUrl;
    private Date SendDate;
    private Date FinishTime;
    private String Like;
    private String Dislike;
    private String Sikayet;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getUserProfileImageUrl() {
        return UserProfileImageUrl;
    }

    public void setUserProfileImageUrl(String userProfileImageUrl) {
        UserProfileImageUrl = userProfileImageUrl;
    }

    public Date getSendDate() {
        return SendDate;
    }

    public void setSendDate(Date sendDate) {
        SendDate = sendDate;
    }

    public Date getFinishTime() {
        return FinishTime;
    }

    public void setFinishTime(Date finishTime) {
        FinishTime = finishTime;
    }

    public String getLike() {
        return Like;
    }

    public void setLike(String like) {
        Like = like;
    }

    public String getDislike() {
        return Dislike;
    }

    public void setDislike(String dislike) {
        Dislike = dislike;
    }

    public String getSikayet() {
        return Sikayet;
    }

    public void setSikayet(String sikayet) {
        Sikayet = sikayet;
    }
}
