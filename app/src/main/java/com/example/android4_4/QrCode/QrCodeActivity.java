package com.example.android4_4.QrCode;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.android4_4.R;
import com.example.android4_4.Utils.QrCodeUtil;

public class QrCodeActivity extends AppCompatActivity {

    private ImageView qr_code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code);
        qr_code = (ImageView)findViewById(R.id.qr_image_view);
        Bitmap bitmap = QrCodeUtil.createQRCodeBitmap("renshijie", 240, 240);
        qr_code.setImageBitmap(bitmap);
    }
}
