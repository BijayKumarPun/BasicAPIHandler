package com.homay.just.apihandler.NetworkHandler;

import android.util.Log;

import com.homay.just.apihandler.Model.DataModel;


import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;

public class RequestHandler {
    private String TAG = "Inside RequestHandler";
    RequestBody requestBody;
    Request request;


    public RequestHandler(DataModel dataModel) {
        requestBody = new FormBody.Builder()
                .add("_id", dataModel.get_id())
                .add("post_title", dataModel.getPost_title())
                .add("post_body", dataModel.getPost_body())
                .add("post_creator", dataModel.getPost_creator())
                .add("post_likes_count", dataModel.getPost_likes_count())
                .add("post_comment_count", dataModel.getPost_comment_count())
                .add("post_view_count", dataModel.getPost_view_count())
                .build();

    }

    public RequestHandler() {
        requestBody = new FormBody.Builder().build();
    }

    public void defineRequest(String MY_URL, String HTTP_METHOD) {

        switch (HTTP_METHOD) {
            case "POST":
                request = new Request.Builder()
                        .url(MY_URL)
                        .post(requestBody)
                        .build();
                break;

            case "GET":
                request = new Request.Builder()
                        .url(MY_URL)
                        .get()
                        .build();
                break;

            default:
                Log.i(TAG, "Error: Invalid Request");
        }


    }


    public void executeRequest() {

        NetworkCommunicator networkCommunicator = new NetworkCommunicator(request, requestBody);
        networkCommunicator.execute();


    }


}
