package com.example.admin.tabbedactivity;

import android.widget.EditText;
import android.widget.TextView;
        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Wallet extends AppCompatActivity {
    TextView t1,balance;
    EditText e1,mob;
    Button b1;
    String upload;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);
        //setContentView(R.layout.login);
        t1=findViewById(R.id.balance);
        mob=findViewById(R.id.mobno);
        e1=findViewById(R.id.amount);
        b1=findViewById(R.id.pay);
        balance=findViewById(R.id.balance);
        final String mob1=mob.getText().toString();
        String server="http://192.168.43.83/php/select.php";
        final RequestQueue requestQueue= Volley.newRequestQueue(Wallet.this);

        StringRequest stringRequest=new StringRequest(Request.Method.POST, server, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                balance.setText(response);
                requestQueue.stop();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                balance.setText("Something went wrong");
                error.printStackTrace();
                requestQueue.stop();
            }
        }){
            @Override
            protected Map<String, String> getParams() {

                // Creating Map String Params.
                Map<String, String> params = new HashMap<String, String>();

                // Adding All values to Params.
                // The firs argument should be same sa your MySQL database table columns.
                params.put("Mobile",mob1);


                return params;
            }

        };


        requestQueue.add(stringRequest);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num1 = e1.getText().toString();
                insert();
                Toast.makeText(Wallet.this, num1,Toast.LENGTH_SHORT).show();
                Intent i =new Intent(Wallet.this,gateway.class);
                i.putExtra("load",num1);
                startActivity(i);
            }

            private void insert() {
                String server="http://192.168.43.83/php/Register2.php";
                final String amount;
                amount=e1.getText().toString();
                StringRequest stringRequest=new StringRequest(Request.Method.POST, server, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        balance.setText(response);
                        requestQueue.stop();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        balance.setText("Something went wrong");
                        error.printStackTrace();
                        requestQueue.stop();
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() {

                        // Creating Map String Params.
                        Map<String, String> params = new HashMap<String, String>();

                        // Adding All values to Params.
                        // The firs argument should be same sa your MySQL database table columns.
                        params.put("Amount",amount);


                        return params;
                    }

                };
                MySingleton.getmInstance(Wallet.this).addrequest(stringRequest);
            }
        });
    }
}
