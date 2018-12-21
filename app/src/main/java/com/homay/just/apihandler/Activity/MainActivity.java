package com.homay.just.apihandler.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
        String POST_URL= getResources().getString(R.string.URL_POST_NEW_POST);

        RequestHandler requestHandler = new RequestHandler(dataModelGlobal);
        requestHandler.defineRequest(POST_URL,"POST");
requestHandler.executeRequest();



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
