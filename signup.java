package com.example.admin.tabbedactivity;

import android.app.VoiceInteractor;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 26-11-2017.
 */

public class signup extends Fragment {
    ImageView imageView;
    String texttoqr;
    MultiFormatWriter multiFormatWriter = new MultiFormatWriter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.signup, container, false);

        Button bt=rootView.findViewById(R.id.signupbt);
        final EditText editText=rootView.findViewById(R.id.Mobile_s);
        imageView = rootView.findViewById(R.id.image);
        return rootView;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button bt = view.findViewById(R.id.signupbt);
        final EditText edit, name, mob, pass, rpass;
        name = view.findViewById(R.id.firstname);
        mob = view.findViewById(R.id.Mobile_s);
        pass = view.findViewById(R.id.passwordsign);
        rpass = view.findViewById(R.id.retype);
        final TextView textView=view.findViewById(R.id.textnav);
        //edit=view.findViewById(R.id.image);

        final String url = "http://192.168.43.83/php/Register.php";
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name1, mob1, pass1, rpass1;
                name1 = name.getText().toString().trim();
                mob1 = mob.getText().toString().trim();
                pass1 = pass.getText().toString().trim();
                rpass1 = rpass.getText().toString().trim();

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(getActivity(), "successful", Toast.LENGTH_SHORT).show();


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(), "Error", Toast.LENGTH_LONG).show();
                        error.printStackTrace();
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<String, String>();
                        params.put("name", name1);
                        params.put("mno", mob1);
                        params.put("pass", pass1);
                        return params;


                    }
                };
                MySingleton.getmInstance(getActivity()).addrequest(stringRequest);

            }

//            private void qrcode() {
//                MultiFormatWriter multiFormatWriter=new MultiFormatWriter();
//                try
//                {
//
//                    texttoqr=mob.getText().toString().trim();
//                    BitMatrix bitMatrix=multiFormatWriter.encode(texttoqr, BarcodeFormat.QR_CODE,2000,2000);
//                    BarcodeEncoder barcodeEncoder=new BarcodeEncoder();
//                    Bitmap bitmap=barcodeEncoder.createBitmap(bitMatrix);
//                    imageView.setImageBitmap(bitmap);
//                }
//                catch (WriterException e)
//                {
//                    e.printStackTrace();
//                }
//
//
        });
//textView.setText();
    }
}

