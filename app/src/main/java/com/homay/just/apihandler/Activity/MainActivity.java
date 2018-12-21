package com.homay.just.apihandler.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.JsonArray;
import com.homay.just.apihandler.Model.DataModel;
import com.homay.just.apihandler.NetworkHandler.NetworkResponseListener;
import com.homay.just.apihandler.NetworkHandler.RequestHandler;
import com.homay.just.apihandler.NetworkHandler.ResponseHandler;
import com.homay.just.apihandler.R;

import java.util.ArrayList;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataModel dataModelGlobal = createStaticDataModel();

        //upload data to Server
        String POST_URL = getResources().getString(R.string.URL_POST_NEW_POST);
        String GET_URL = getResources().getString(R.string.URL_POST_LIST_ALL);
        String GET_BY_ID_URL = getResources().getString(R.string.URL_POST_LIST_POST_BY_ID);
        DataModel dataModel = new DataModel();
dataModel.setPost_creator("John Cena");

        RequestHandler requestHandler3 = new RequestHandler(dataModel.getRequestBody(), getResources().getString(R.string.URL_POST_LIST_BY_CREATOR), "POST");
        requestHandler3.setNetworkResponseListener(new NetworkResponseListener() {
            @Override
            public void onExecutionComplete(JsonArray jsonArrayResonse) {
                Log.i(TAG, "onExecutionComplete: " + jsonArrayResonse.toString());

                ArrayList<DataModel> dataModels=  new ResponseHandler().intoModelObjects(jsonArrayResonse);


                for (int i = 0; i < dataModels.size(); i++) {
                    Log.i(TAG, "onExecutionComplete: datamodels title"+dataModels.get(i).getPost_title());
                }


            }
        });
        requestHandler3.execute();




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
