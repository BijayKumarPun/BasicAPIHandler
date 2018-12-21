package com.homay.just.apihandler.NetworkHandler;

import com.google.gson.JsonArray;

public interface NetworkResponseListener {

    void onExecutionComplete(JsonArray jsonArrayResonse);

}
