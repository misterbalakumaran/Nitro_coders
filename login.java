package com.example.admin.tabbedactivity;

/**
 * Created by admin on 26-11-2017.
 */
import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;


public class login extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.login, container, false);

        return rootView;


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final EditText mob=view.findViewById(R.id.Mobile_1);
        final EditText pass=view.findViewById(R.id.passwordlog);
        Button bt=view.findViewById(R.id.Loginbt);
        final String url="http://192.168.43.83/php/log.php";
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String mob1,pass1;
                mob1=mob.getText().toString().trim();
                pass1=pass.getText().toString().trim();
                RequestQueue requestQueue = Volley.newRequestQueue(getActivity());

                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String ServerResponse) {

                                // Hiding the progress dialog after all task complete.
                                //progressDialog.dismiss();

                                // Matching server responce message to our text.
                                //if(ServerResponse.equalsIgnoreCase("Data Matched")) {
                                Toast.makeText(getActivity(), "toast0"+mob1, Toast.LENGTH_SHORT).show();
Intent intent=new Intent(getActivity(),Home.class);
intent.putExtra("mobile",mob1);
startActivity(intent);
                                    // If response matched then show the toast.
                               //     Toast.makeText(getActivity(), "Logged In Successfully", Toast.LENGTH_LONG).show();

                                    // Finish the current Login activity.


                                    // Opening the u,ser profile activity using intent.

                                    // Sending User Email to another activity using intent.

                               // }
//                                else {
//
//                                    // Showing Echo Response Message Coming From Server.
//                                    Toast.makeText(getActivity(), ServerResponse, Toast.LENGTH_LONG).show();
//
//                                }


                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError volleyError) {

                                // Hiding the progress dialog after all task complete.
                                //progressDialog.dismiss();

                                // Showing error message if something goes wrong.
                                Toast.makeText(getActivity(), volleyError.toString(), Toast.LENGTH_LONG).show();
                            }
                        }) {
                    @Override
                    protected Map<String, String> getParams() {

                        // Creating Map String Params.
                        Map<String, String> params = new HashMap<String, String>();

                        // Adding All values to Params.
                        // The firs argument should be same sa your MySQL database table columns.
                        params.put("Mobile", mob1);
                        params.put("Password", pass1);

                        return params;
                    }

                };
                requestQueue.add(stringRequest);

               // MySingleton.getmInstance(getActivity()).addrequest(stringRequest);

            }
        });
    }
}


