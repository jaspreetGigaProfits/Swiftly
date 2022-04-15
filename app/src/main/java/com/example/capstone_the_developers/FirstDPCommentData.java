package com.example.capstone_the_developers;

public class FirstDPCommentData {
    String comment;
    String id;


    public FirstDPCommentData(String id,String comment) {
        this.id=id;
        this.comment=comment;

    }

    public void FirstDPCommentData() {
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}

