package com.example.hackathon;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {

    EditText user_name_log,psw_log;
    Button sign_in_log;
    TextView tv_regpage_log;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user_name_log = findViewById(R.id.user_name_log);
        psw_log = findViewById(R.id.psw_log);
        sign_in_log = findViewById(R.id.sign_in_log);
        
       /* tv_regpage_log = findViewById(R.id.tv_regpage_log);
        tv_regpage_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Register.class);
                startActivity(i);
            }
        });*/

        sign_in_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_login();
            }
        });
        
    }

    private void user_login() {


    }
}