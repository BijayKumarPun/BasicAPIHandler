package com.homay.just.apihandler.NetworkHandler;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class NetworkCommunicator extends AsyncTask<Void,Void,Void> {
    String TAG = "Network Communicator";
    Request request;
    RequestBody requestBody;

    public NetworkCommunicator(Request request, RequestBody requestBody) {
        this.request= request;
        this.requestBody = requestBody;

    }

    @Override
    protected Void doInBackground(Void... voids) {
        OkHttpClient okHttpClient  = new OkHttpClient();


        try {
            Response response = okHttpClient.newCall(request).execute();
            if(response.isSuccessful()){
                Log.i(TAG, "doInBackground: Successful");
                Log.i(TAG, "Response: " + response.body().toString());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }
}
