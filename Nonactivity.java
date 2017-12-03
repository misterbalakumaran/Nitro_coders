package com.example.admin.tabbedactivity;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Nonactivity
{
    Context context;
    View view;

    public Nonactivity(Context context, View view) {
        this.context = context;
        this.view = view;
    }
    public void test()

    {
        Button bt=view.findViewById(R.id.Loginbt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "sdfsd", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
