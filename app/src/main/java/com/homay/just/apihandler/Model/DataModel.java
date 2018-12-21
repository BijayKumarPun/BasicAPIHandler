package com.homay.just.apihandler.Model;

import okhttp3.FormBody;
import okhttp3.RequestBody;

public class DataModel {

    private String _id;
    private String post_title;
    private String post_body;
    private String post_creator;
    private String post_likes_count;
    private String post_comment_count;
    private String post_view_count;


    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getPost_title() {
        return post_title;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }

    public String getPost_body() {
        return post_body;
    }

    public void setPost_body(String post_body) {
        this.post_body = post_body;
    }

    public String getPost_creator() {
        return post_creator;
    }

    public void setPost_creator(String post_creator) {
        this.post_creator = post_creator;
    }

    public String getPost_likes_count() {
        return post_likes_count;
    }

    public void setPost_likes_count(String post_likes_count) {
        this.post_likes_count = post_likes_count;
    }

    public String getPost_comment_count() {
        return post_comment_count;
    }

    public void setPost_comment_count(String post_comment_count) {
        this.post_comment_count = post_comment_count;
    }

    public String getPost_view_count() {
        return post_view_count;
    }

    public void setPost_view_count(String post_view_count) {
        this.post_view_count = post_view_count;
    }


    public DataModel() {



    }

    public RequestBody getRequestBody(String body_type) {
        switch (body_type) {
            case "POST":
                return new FormBody.Builder()
                        .add("_id", this.get_id())
                        .add("post_title", this.getPost_title())
                        .add("post_body", this.getPost_body())
                        .add("post_creator", this.getPost_creator())
                        .add("post_likes_count", this.getPost_likes_count())
                        .add("post_comment_count", this.getPost_comment_count())
                        .add("post_view_count", this.getPost_view_count())
                        .build();

            case "GET":
                return new FormBody.Builder()
                        .build();
        }

        return null;
    }

    public RequestBody getRequestBodyBy(String parameter, String value) {
        return new FormBody.Builder()
                .add(parameter, _id)
                .build();
    }





}
