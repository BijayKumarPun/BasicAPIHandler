package com.homay.just.apihandler.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.homay.just.apihandler.Model.DataModel;
import com.homay.just.apihandler.NetworkHandler.RequestHandler;
import com.homay.just.apihandler.NetworkHandler.ResponseHandler;
import com.homay.just.apihandler.R;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataModel dataModelGlobal = createStaticDataModel();

        //upload data to Server
        String POST_URL = getResources().getString(R.string.URL_POST_NEW_POST);
        String GET_URL = getResources().getString(R.string.URL_POST_LIST_ALL);
        String GET_BY_ID_URL = getResources().getString(R.string.URL_POST_LIST_POST_BY_ID);


        //Post a DATA MODEL
        RequestHandler requestHandler = new RequestHandler(dataModelGlobal.getRequestBody("POST"), POST_URL, "POST");
        requestHandler.executeRequest();


        //Get a DATA MODEL
        RequestHandler requestHandler1 = new RequestHandler(dataModelGlobal.getRequestBody("GET"), GET_URL, "GET");
        requestHandler1.executeRequest();

//Get data model by id

        RequestHandler requestHandler2 = new RequestHandler(dataModelGlobal.getRequestBodyBy("_id", "whothis232asd3"), GET_BY_ID_URL, "POST");
        requestHandler2.executeRequest();

    }


























    private DataModel createStaticDataModel() {
        //This creates a  DataModel instance with generic values
        DataModel dataModel = new DataModel();

        //Total fields = 7
        dataModel.set_id(UUID.randomUUID().toString());
        dataModel.setPost_title("Some title");
        dataModel.setPost_body("Some body");
        dataModel.setPost_comment_count("50");
        dataModel.setPost_likes_count("300");
        dataModel.setPost_view_count("400");
        dataModel.setPost_creator("John Cena");

        return dataModel;
    }

}
