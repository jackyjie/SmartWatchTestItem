package com.example.android4_4.Utils;

/**
 * Created by JackR on 2018/3/30.
 */

public interface HttpCallbackListener {
    void onFinish(String response);
    void onError(Exception ex);
}
