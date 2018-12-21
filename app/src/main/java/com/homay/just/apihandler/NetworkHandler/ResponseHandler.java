package com.homay.just.apihandler.NetworkHandler;

import android.provider.ContactsContract;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.homay.just.apihandler.Model.DataModel;

import java.util.ArrayList;

public class ResponseHandler {
    public ResponseHandler() {

    }


    public ArrayList<DataModel> intoModelObjects(JsonArray jsonArray) {
        ArrayList<DataModel> dataModels = new ArrayList<>();
        for (int i = 0; i < jsonArray.size() - 1; i++) {

            dataModels.add(new Gson().fromJson(jsonArray.get(i), DataModel.class));

        }
        return dataModels;
    }

}
