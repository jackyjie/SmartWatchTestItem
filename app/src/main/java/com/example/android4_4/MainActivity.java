package com.example.android4_4;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.android4_4.QrCode.QrCodeActivity;
import com.example.android4_4.Utils.HttpCallbackListener;
import com.example.android4_4.Utils.HttpUtil;
import com.example.android4_4.Utils.MyApplication;
import com.example.android4_4.Utils.QrCodeUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button wifi_test = (Button) findViewById(R.id.wifi_test);;
        Button qrcode_test = (Button) findViewById(R.id.qrcode_test);;
        Button qrcode_scan_test = (Button) findViewById(R.id.qrcode_scan_test);
        wifi_test.setOnClickListener(this);
        qrcode_test.setOnClickListener(this);
        qrcode_scan_test.setOnClickListener(this);
        Log.d(TAG, "onCreate: ");
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.wifi_test:
                testwifi();
                break;
            case R.id.qrcode_test:
                testqrcode();
                break;
            case R.id.qrcode_scan_test:
                testqrcodescan();
                break;
        }
    }

    private void testqrcode(){
        Intent intent = new Intent(this, QrCodeActivity.class);
        startActivity(intent);
    }

    private void testqrcodescan(){
//        Intent intent = new Intent(this, CaptureActivity.class);
//        startActivity(intent);
    }

    private void testwifi(){
        HttpUtil.sendOkHttpRequest("http://192.168.4.106:8101/api/user/list", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MyApplication.getContext(), "返回失败", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MyApplication.getContext(), "返回成功", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
