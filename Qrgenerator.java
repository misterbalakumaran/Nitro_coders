package com.example.admin.tabbedactivity;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class Qrgenerator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrgenerator);
        String texttoqr=getIntent().getExtras().getString("qrtext");
        ImageView imageView=findViewById(R.id.image);
        MultiFormatWriter multiFormatWriter=new MultiFormatWriter();
        try
        {

            //texttoqr=edit.getText().toString().trim();
            BitMatrix bitMatrix=multiFormatWriter.encode(texttoqr, BarcodeFormat.QR_CODE,1000,1000);
            BarcodeEncoder barcodeEncoder=new BarcodeEncoder();
            Bitmap bitmap=barcodeEncoder.createBitmap(bitMatrix);
            imageView.setImageBitmap(bitmap);
        }
        catch (WriterException e)
        {
            e.printStackTrace();
        }
    }
}
